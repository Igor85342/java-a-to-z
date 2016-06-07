package zanaytie3;

public class Main{

	public static void main(String[] args){
		Point a = new Point(5,7);
		Point b = new Point(4,10);
		Point c = new Point(8,2);
		
		Triangle triangle = new Triangle(a,b,c);	
		
		double s = triangle.area();
		System.out.printf("S - %f",s);
		
		
		

	}
}

