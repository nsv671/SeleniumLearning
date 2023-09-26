package corejava;

public class WhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<=10) {
			System.out.println("WhileLoop - "+i);
			i++;
		}
		
		do {
			System.out.println("DoWhileLoop - "+i);
			i--;
		}while(i>0);
	}

}
