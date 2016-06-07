package zanaytie3;

public class Triangle {
	public double s;
	public Point a;
	public Point b;
	public Point c;
	public double ab;
	public double bc;
	public double ca;
	public Point tempPoint;
	

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double area(){

		boolean checkSide = false;
		boolean checkSideSquare = false;
		double cd = 1;
		double da = 2;
		tempPoint = a;

		
		this.ab = distanceTo(b);
 		

		this.bc = distanceTo(c);
		

		this.ca = distanceTo(a);
		

		Side side = new Side();
		checkSide = side.max(ab,bc,ca);
		if (checkSide) {
			System.out.println("ab - max");	
		}

		checkSide = side.max(bc,ca,ab);
		if (checkSide) {
			System.out.println("bc - max");	
		}

		checkSide = side.max(ca,ab,bc);
		if (checkSide) {
			System.out.println("ca - max");	
		}


		SideSquare sideSquare = new SideSquare();
		checkSideSquare = sideSquare.max(ab,bc,cd,da);
		if (checkSideSquare) {
			System.out.println("ab - max(square)");	
		}

		
		checkSideSquare = sideSquare.max(bc,cd,da,ab);
		if (checkSideSquare) {
			System.out.println("bc - max(square)");	
		}

		checkSideSquare = sideSquare.max(cd,da,ab,bc);
		if (checkSideSquare) {
			System.out.println("cd - max(square)");	
		}

		checkSideSquare = sideSquare.max(da,ab,bc,cd);
		if (checkSideSquare) {
			System.out.println("da - max(square)");	
		}

		
		double value;
		double p;
		double s = -1;
		if (isExists(ab,bc,ca)){
				p = (ab + bc + ca)/2;
				s = Math.sqrt(p * (p - ab)*(p - bc)*(p - ca));
		}		
		return s;
	}

	

	public double distanceTo(Point pointB) {
		Point pointA = this.tempPoint;
		double value =	(pointB.x - pointA.x)*(pointB.x - pointA.x) + (pointB.y - pointA.y)*(pointB.y - pointA.y);
		value = Math.sqrt(value);
		this.tempPoint = pointB;
		return value;
 	
	}

	public boolean	isExists(double ab, double bc, double ca){
	
		if ((ab > 0) & (bc > 0) & (ca > 0)) {
			if ((ab + bc > ca)&(bc + ca > ab)&(ca + bc > ab)) {
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