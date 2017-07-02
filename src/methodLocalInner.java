
	import java.util.*;
	class methodLocalInner 
	{  
		private int m_data;
	  
	  	public static void main (String[] args) throws Exception 
	  	{
	  		methodLocalInner outer = new methodLocalInner();
			outer.doInner();
	  	}
	  	
	  	private void saySomethingOuter()
	  	{
	  		System.out.println("Outer class method");
	  	}
	  
	  	private void doInner()
	  	{
	      	int m_local;
	      	// method local inner class
	  		class Inner
	  		{
	  		 	public Inner()
	  		 	{
	  		 		m_data = 1;
	  		    		
	  		 		saySomething();
	  		    
	  		    	// m_local = 2; can't access outer local from inner class
	  		 	}
	  		 	
	  		 	public void saySomething()
	  		 	{
	  		 		System.out.println("The inner is setting a member of the outer");
	  		 	}
	  		}
	  		Inner inner = new Inner();
	  		
	  		new Inner()
	  		{
	  			{
	  				System.out.println("Static code block called");
	  			}
	  			
	  			public void saySomething()
	  			{
	  				System.out.println("Constructing an anonymous inner class");
	  				
	  				methodLocalInner.this.saySomethingOuter();
	  			}
	  		};
	  	}
	} 
