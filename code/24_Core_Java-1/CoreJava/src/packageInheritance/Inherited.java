package packageInheritance;

public class Inherited extends Child{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parent parentObject = new Inherited();
		System.out.println(parentObject.name);
		parentObject.parentMethod();
		parentObject.commonMethod();
		
		Child childObject = new Inherited();
		System.out.println(childObject.name);
		childObject.childMethod();
		childObject.childMethod();

		Inherited inheritedObject = new Inherited();
		System.out.println(inheritedObject.name);
		inheritedObject.commonMethod();
	}

}
