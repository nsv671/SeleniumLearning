package coreJave2;

public class DemoChild extends DemoParent{
	static String name = "Child Name";
	
	public DemoChild() {
		super(); // this should always be at first line we are invoking the parent class constructor
		System.out.println("Child class constructor");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoChild demoChild = new DemoChild();
		demoChild.getName();
		demoChild.getData();
	}
	
	private void getName() {
		System.out.println(name);
		System.out.println(super.name);
	}
	
	public void getData() {
		System.out.println("Child class method");
		super.getData();
	}
}
