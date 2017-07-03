public class varargs {
	
	public static void main(String args[])
	{
		int x=1;
		int y=2;
		int z=3;
		
		multiArgs(x,y,z);
		
		Constructor constructor = new Constructor(1);
		
		Array array = new Array();
		
		MyEnum.enumMember tom = MyEnum.enumMember.TOM;
		switch(tom)
		{
		case TOM:
			System.out.println("TOM");
			break;
		case DICK:
			System.out.println("DICK");
			break;
		case HARRY:
			System.out.println("HARRY");
			break;
		case BASIL:
			System.out.println("BASIL");
			break;				
		default:
		}
		
		MyEnumClass size = MyEnumClass.BIG;
		size.printSize();
		
	}
	
	private static void multiArgs(int...args)
	{
		for(int arg:args)
		{
			System.out.println(arg);
		}
		System.out.println(args[0]);
	}
}
