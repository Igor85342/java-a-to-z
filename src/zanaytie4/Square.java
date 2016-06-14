package zanaytie4;

import static java.lang.Math.*;
public class Square{

	 double a;
	 double b;
	 double c;

	Square (double a, double b, double c) {

	this.a = a ;
	this.b = b ;
	this.c = c ;

	}

	
	public void floatCalculate(double step){
		double  d;
		double x1;
		double x2;
		System.out.println(a);	
		d = Math.pow(b,2) - 4 * a * c;
		
		if ( d < 0 ) {
			System.out.println("The quadratic equation has no solution.");	
		}

		if ( d == 0) {
			System.out.println("One root");	
		}
		
		if ( d > 0 ) {
			x1 = (- b - sqrt(d))/ 2 * a;	
			x2 = (- b + sqrt(d))/ 2 * a;	
			
			for (double i = x1; i <= x2; i = i + step){
				System.out.println(i);	
			}
		}
		
		

	}
}

