package zanaytie3;

public class Main{

	public static void main(String[] args){
		Point a = new Point(3,8);
		Point b = new Point(5,5);
		Point c = new Point(7,1);
		
		Triangle triangle = new Triangle(a,b,c);	
		triangle.length();
		triangle.check();
		
		
		

	}
}

