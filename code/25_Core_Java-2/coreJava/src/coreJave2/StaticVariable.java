package coreJave2;

public class StaticVariable {
	String name; //Instance Variable
	String address;
	static String citi="sundargarh"; // class variable
	static int i;
	static String country;
	
	static {	//Static block
		 i=0;
		 country = "Bharat";
	}
	
	StaticVariable(String name, String address){
		this.name = name; // name is local variable where as this.name is instance variable
		this.address = address;
		i++;
		System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticVariable object1 = new StaticVariable("nitesh", "balisankara");
		object1.getName();

		StaticVariable object2 = new StaticVariable("golu", "sarbhal");
		object2.getName();
		
		StaticVariable.getCiti();
		System.out.println(StaticVariable.country);
	}
	
	public void getName() {
		System.out.println(this.name);
	}
	
	//static method can only take static variable
	static void getCiti() {
		System.out.println(citi);
	}

}
