package packageInheritance;

public class Child extends Parent {

	String name = "Child";
	
	public void childMethod() {
		System.out.println("In child class child method implemented");
	}
	
	public void commonMethod() {
		System.out.println("Common method implemented in child class");
	}

}
