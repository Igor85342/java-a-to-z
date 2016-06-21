package zanaytie5;


public class Bubble{

	

	public static void main(String[] args){
		
		int[] values = new int[]{4,6,1,9,3,4,32,45,2,12};

		
		Bubble bubble = new Bubble();
		bubble.outputArray(values);
		values = bubble.sorting(values);
		
		
		
		System.out.println();
		
		bubble.outputArray(values);
		

	}

	public void outputArray(int[] values){
		
		for (int value : values ) {
			System.out.print(value + " ");
		}
	}
	public int[] sorting(int[] values){
		for (int k = 1; k!= values.length; k++) {
        		for (int index = 0; index!= values.length - 1; index++) {

				if (values[index] > values[index + 1]) {

					int temp = values[index];
					values[index] = values[index + 1];
					values[index + 1] = temp;
				}
			}

		}
		return values;		
	}

}

