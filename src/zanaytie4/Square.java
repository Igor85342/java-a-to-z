package zanaytie4;

import static java.lang.Math.*;
public class Square{

	
	double x1;
	double x2;

	

	public static void main(String[] args){
		double a = 1;
		double b = -5;
		double c  = 3;
		double step = Double.valueOf(args[0]);
		Square square = new Square();	
		square.floatCalculate(a,b,c,step);

		for (double i = square.x1; i <= square.x2; i = i + step){
				System.out.println(i);	
			}
		
	}

	public void floatCalculate(double a, double b, double c, double step){
		double  d;
		
		System.out.println(a);	
		d = Math.pow(b,2) - 4 * a * c;
		
		if ( d < 0 ) {
			System.out.println("The quadratic equation has no solution.");	
		}

		if ( d == 0) {
			System.out.println("One root");	
		}
		
		if ( d > 0 ) {
			this.x1 = (- b - sqrt(d))/ 2 * a;	
			this.x2 = (- b + sqrt(d))/ 2 * a;	
			
			
		}
		
		

	}
}

