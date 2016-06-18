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
	
	
	

	public static void main(String[] args){
		
		double a = Double.valueOf(args[0]);
		double b = Double.valueOf(args[1]);
		double c = Double.valueOf(args[2]);
		double x1 = Double.valueOf(args[3]);
		double x2 = Double.valueOf(args[4]);
		double step = Double.valueOf(args[5]);
		
		int x =4;
 
		Square square = new Square(a,b,c);	
		float y = square.calculate(x);
		System.out.println(y);
		for (double i = x1; i <= x2; i = i + step){
				System.out.println(i);	
		}
		
	}

	public float calculate(int x){
		
		return (float)(this.a * Math.pow(x,2) + this.b * x + this.c);
		
		

	}
}

