package zanaytie3;

public class Triangle {
	public static double s;
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
	
	public double area(){
		
		double value;
		value = (b.x - a.x)*(c.y - a.y)-(c.x - a.x)*(b.y-a.y);
		s = Math.abs(value)/2;
		System.out.println("S - " + s);
		return -1;
	}

	public void check(){
	
		if ((ab > 0) & (bc > 0) & (ca > 0)) {
			if ((ab + bc > ca)&(bc + ca > ab)&(ca + bc > ab)) {
				this.area();
			}
			else {
				System.out.println("The triangle does not exist.");				
			}
		}
		else {
			System.out.println("The triangle does not exist.");
		}
		
	}


	public void length() {

		boolean checkSide = false;
		boolean checkSideSquare = false;
		double cd = 5;
		double da = 2;

		this.ab = distanceTo(a,b);
 		System.out.println(ab);

		this.bc = distanceTo(b,c);
		System.out.println(bc);

		this.ca = distanceTo(c,a);
		System.out.println(ca);

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

	}

	public double distanceTo(Point pointA, Point pointB) {
		double value;
		value =	(pointB.x - pointA.x)*(pointB.x - pointA.x) + (pointB.y - pointA.y)*(pointB.y - pointA.y);
		value = Math.sqrt(value);
		return value;
 	
	}

			
	
}