package coreJave2;

// final class can't be extended
final public class DemoFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//final variable we won't be able to alter
		final int x = 671;
//		x = 123; //this will throw error
		System.out.println(x);

	}
	
	
	// This method can't be overridden
	final public void method() {
		System.out.println("Method");
	}

}
