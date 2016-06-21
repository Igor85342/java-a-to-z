package zanaytie5;

public class SquareArray{

	public static void main(String[] args){
			
		int values[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		SquareArray array = new SquareArray();

		array.display(values);		
		values = array.inversion(values);
		array.display(values);
	}

	public void display(int[][] values){

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j< 3 ; j++ ){
				System.out.print( values[i][j] + " ");
				
			}
			System.out.println();	
		}
		
		System.out.println();
	}	
	public int[][] inversion(int[][] values){
		int temp[][] = new int [3][3];

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++){

				temp[j][i] = values[i][j];
			}

		} 
		return temp;
	}
}

