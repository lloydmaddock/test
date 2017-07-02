import java.util.*;
import java.io.*;

public class template {
	
	class A{void AMethod(){};}
	
	class B extends A{void BMethod(){};}
	
	class C extends B{void CMethod(){};}
		
	public static void main(String[] args)
	{
		template X=new template();
		X.doIt();
	}
	
	void doIt()
	{
		// For a super template, the instantiation must match or be a parent of 'B'
		// The compiler only considers the reference type 'B' and not the actual type 'C'
		
		List<? super B> superTemplate = new ArrayList<A>();
		
		// We can only call methods with types that we are sure match or or children of the
		// reference type since we don't know which parent we have and can't add a parent that 
		// might be too far up the hierarchy to match the actual type.
		
		// superTemplate.add(new A()); A might not match the particular B superclass
		
		superTemplate.add(new B()); // B must match B or be a subclass of the particular B superclass 
		
		superTemplate.add(new C()); // C must be a subclass of the particular B superclass
		
		superTemplate.add(null); // null can map to anything so this is OK
		
		// We can only return types that we can be sure the actual type will implement
		// since the actual type could be any level up, that means almost nothing will work....
		
		// A a = superTemplate.get(0); can't be sure the particular B superclass is an A
		
		// B b = superTemplate.get(0); can't be sure the particular B superclass is a B
		
		// C c = superTemplate.get(0); C isn't a superclass of B
		
		Object o = superTemplate.get(0); // actual type must be an Object or a subclass of Object
		
		// For an extends template, the instantiation must match or be a child of 'B'
		// The compiler only considers the reference type 'B' and not the actual type 'C'
		
		List<? extends B> extendsTemplate = new ArrayList<C>();
		
		// we can only call methods with types that we can be sure implement the actual
		// type of the child of 'B' in the instantiation ... that means almost nothing will work...
		
		// extendsTemplate.add(new A()); A isn't a subclass of B
		
		// extendsTemplate.add(new B()); can't be sure B is a subclass of the particular B subclass used
		
		// extendsTemplate.add(new C()); can't be sure C is a subclass of the particular B subclass used
		
		extendsTemplate.add(null); // null can map to anything so this is OK
		
		// We can only return types that we can be sure the actual type will implement
		// That means the type must be guaranteed to be able to hold whatever type the actual subclass of 'B' is
		
		// A a = extendsTemplate.get(0); A is not a subclass of B
		
		 B b = extendsTemplate.get(0); //The particular superclass must be B or a subclass of B
		
		// C c = extendsTemplate.get(0); can't be sure the particular B superclass is an A
		
		 Object o2 = extendsTemplate.get(0); // actual type must be an Object or a subclass of Object
		 
		 File f = new File("d:\\tmp\\xxx.txt");
		 
		 try {
			 
			f.createNewFile();
			
			FileOutputStream ofs = new FileOutputStream(f);
			
			ObjectOutputStream obs = new ObjectOutputStream(ofs);
			
			obs.writeObject(o2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
