package zanaytie4;


public class Factorial{

	

	public static void main(String[] args){
		
		
		int step = 10;
		
		Factorial factorial = new Factorial();
		
		
        	int value = factorial.calculationFactorial(step);
		System.out.println(value);
	
	}
	
	public int calculationFactorial(int step){
		int value = 1;	
		for (int i = 1; i < step +1 ; i++) {

			value = value * i;	
		}
		return value;
	}
		
		

	
}

