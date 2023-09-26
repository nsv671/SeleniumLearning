package corejava;

public class MaximumNumberInMinimumNumberColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{4,5,7,0},{7,98,4,8}, {8, 89,11,3},{2, 8,7,99}};
		
		int min = Integer.MAX_VALUE;
		int row = 0, column = 0;
		
		for(int i=0; i< array.length; i++)
			for(int j=0; j< array[i].length; j++)
				if(min>array[i][j]) {
					min = array[i][j];
					row = i;
					column = j;
				}
		
//		System.out.println("MINIMUM value -> "+min+"\tROW -> "+row+"\tColumn -> "+column);
		
		int max = Integer.MIN_VALUE;
//		int max = array[0][column];
		for(int j=0; j< array.length; j++) {
			if(max<array[j][column]) {
				max = array[j][column];
			}
		}
		
		System.out.println("Row -> "+row+"\tColumn -> "+column+"\tMaximum -> "+max);
	}

}
