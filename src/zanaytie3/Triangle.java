package zanaytie3;

public class Triangle {
	public double s;
	public Point a;
	public Point b;
	public Point c;
	public double ab;
	public double bc;
	public double ca;
	
	

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public static void main(String[] args){
		Point a = new Point(5,7);
		Point b = new Point(4,10);
		Point c = new Point(8,2);
		
		Triangle triangle = new Triangle(a,b,c);	
		
		double s = triangle.area();
		System.out.printf("S - %f",s);

	}



	public double area(){
	
		double p;
		s = 0;
		if (isExists()){
				p = (ab + bc + ca)/2;
				s = Math.sqrt(p * (p - ab)*(p - bc)*(p - ca));
		}
	
		return s;
		
	}

	
	public boolean	isExists(){

		this.ab = a.distanceTo(b);
 		this.bc = b.distanceTo(c);
		this.ca = c.distanceTo(a);

		

		if ((this.ab > 0) & (this.bc > 0) & (this.ca > 0)) {
			if ((this.ab + this.bc > this.ca)&(this.bc + this.ca > this.ab)&(this.ca + this.bc > this.ab)) {
				return true;
			}
			else {
				
				return false;	
			}
		}	
		else {
			
			return false;
		}
	}	
}