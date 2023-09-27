package coreJave2;

public class DemoConstructor {
	// Constructor criteria
	// 1 - it should not have any return type
	// 2 - it name should be same as the class name

	// Default constructor
	public DemoConstructor() {
		System.out.println("Constructor is called");
		System.out.println("Constructor body is  being executed");
	}
	
	// Parameterized Constructor
	
	public DemoConstructor(int a, int b) {
		System.out.println("Parameterized Constructor is called");
		System.out.println("Parameterized Constructor body is  being executed");
		System.out.println(a+b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// constructor body get executed whenever we initialize any object
		//if we don't create a constructor then java automatically execute a implicit(default constructor) 
		DemoConstructor constructor = new DemoConstructor();
		
		@SuppressWarnings("unused")
		DemoConstructor parameterizedConstructor = new DemoConstructor(2,3);
		
		constructor.method();
	}
	
	public void method() {
		System.out.println("Method body is being executed");
	}

}
