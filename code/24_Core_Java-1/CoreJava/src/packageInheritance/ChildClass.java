package packageInheritance;

public class ChildClass extends ParentClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildClass childClassObject = new ChildClass();
		System.out.println(childClassObject.color);
		childClassObject.engine();
		childClassObject.gearSystem();
		childClassObject.breakSystem();
	}

	public void engine() {
		System.out.println("Engine code implemented in child class");
	}

}
