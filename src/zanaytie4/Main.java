package zanaytie4;


public class Main{

	

	public static void main(String[] args){
		
		double step = Double.valueOf(args[0]);
		Square square = new Square(1,-5,-3);	
		square.floatCalculate(step);
		
	}
}

