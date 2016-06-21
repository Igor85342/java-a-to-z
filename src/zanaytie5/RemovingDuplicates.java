package zanaytie5;

public class RemovingDuplicates{

	public static void main(String[] args){
		
		String[] numbers = {"one", "two" ,"three", "two", "four","four","five","six","five"};
		RemovingDuplicates array = new RemovingDuplicates();

		array.display(numbers); 
		numbers = array.deleteDuplicates(numbers);
		array.display(numbers); 
		

	}

	public void display(String[] numbers){
		for (String number: numbers) {
		
			System.out.println(number);
		}
	}

	public String[] deleteDuplicates(String[] numbers){
		int count = 0;
		for (int i = 0 ; i != numbers.length; i++) {
		
			for (int j = i + 1; j!= numbers.length; j++ ) {
				
				if (numbers[i]!=null){

					if (numbers[i].equals(numbers[j])) {

						numbers[j]=null;
						count = count + 1;		
					}
				}
			}
		} 
		System.out.println();
		String[] temp = new String[numbers.length - count];
		count = 0;
		
		for (int index = 0; index!= numbers.length; index++){
		
			if (numbers[index] != null){
				temp[index - count] = numbers[index];
			} else {
				count = count + 1;
			}
		}
		return temp;
	}
}

