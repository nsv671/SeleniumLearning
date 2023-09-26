package corejava;

public class FunctionOverLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Function/Method over loading condition
		// 1 - having function input different data type
		// 2 - having different number of argument
		// 3 - or both the combination of rule-1 and rule-2
		print(5);
		print(5, 10.2f);
		print(5,11.2);
		print("Nitesh");
	}
	
	public static void print(int integer) {
		System.out.println(integer);
	}
	
	public static void print(String string) {
		System.out.println(string);
	}
	
	public static void print(int integer, float floatType) {
		System.out.println(floatType);
	}
	
	public static void print(int integer, double doubleType) {
		System.out.println(doubleType);
	}

}
