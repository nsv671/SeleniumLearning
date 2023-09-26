package packageInheritance;

public class FunctionOverRiding extends ChildClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionOverRiding functionOverRiding = new FunctionOverRiding();
		
		functionOverRiding.engine();
		functionOverRiding.audioSystem();
	}
	
	public void engine() {
		System.out.println("Engine code implemented in this class");
	}

}
