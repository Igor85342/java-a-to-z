package zanaytie3;

public class Main{

	public static void main(String[] args){
		Point a = new Point(0,0);
		Point b = new Point(4,0);
		Point c = new Point(1,3);
		
		Triangle triangle = new Triangle(a,b,c);	
		triangle.proverka();
		triangle.length();
		
		

	}
}

