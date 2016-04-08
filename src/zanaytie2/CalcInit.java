package zanaytie2;

public class CalcInit	{

	public static void main(String[] args){
	
	Calculator calculator = new Calculator();
	
	calculator.add(10,20);
	calculator.showResult();
	calculator.substruct( 100,30);
	calculator.showResult();
	calculator.multiple(10,20);
	calculator.showResult();
	calculator.div(120,2);
	calculator.showResult();
	}
}