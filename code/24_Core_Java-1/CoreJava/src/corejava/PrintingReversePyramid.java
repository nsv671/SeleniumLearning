package corejava;

public class PrintingReversePyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pyramid();
		reversePyramid();
	}
	
	private static void pyramid() {
//		int k=1;
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(j+1);
				System.out.print("\t");
//				k++;
			}
			System.out.println();
		}
	}
	
	private static void reversePyramid() {
//		int k=1;
		for(int i=0; i<4; i++) {
			for(int j = 0; j<4-i; j++) {
				//System.out.print(" "+k+" ");
				System.out.print(j+1);
				System.out.print("\t");
//				k++;
			}
			System.out.println();
		}
	}

}
