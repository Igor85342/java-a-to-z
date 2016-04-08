package zanaytie2;

public class Calculator {

	double result = 0;

	
	
	public void add(double first, double second){	
		this.result = first + second;	
	}

	public void substruct(double first, double second){	
		this.result = first - second;	
	}

	public void multiple(double first, double second){	
		this.result = first * second;
	}
	
	public void div(double first, double second){	
		this.result = first / second;	
	}

	public void showResult(){

	System.out.println(result);

	}


}

