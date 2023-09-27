package coreJave2;

public class DemoException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		int b=7;
		int c = 0;
		
		//catch should be an immediate block after the try
		try {
			c = b/a;
		}catch(Exception e) {
			System.out.println("i found the exception");
			System.out.println(e);
		}
		
		// one try block can have multiple catch blocks
		try {
			int[] array = new int[5];
			System.out.println(array[6]);;
		}catch(ArithmeticException e) {
			System.out.println(e);
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			// this block execute irrespective of exception thrown or not
			System.out.println("Delet the cookies");
		}
	}

}
