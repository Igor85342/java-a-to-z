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
		System.out.println(s);
		return -1;
	}

	public void proverka(){
	if ((a.x == b.x)&(b.x == c.x)) {
		System.out.println("Tri tochki legat na odnoi praymoi");
	}
	else {
		if ((a.y == b.y)&(b.y == c.y)){
		System.out.println("Tri tochki legat na odnoi praymoi");
		}
		else {
		
		this.area();
		}
	}
	}

	public void vuvod() {
		System.out.println("Proverka");
	}

	public void length() {

		double value;
		
		value =	(b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y);
		this.ab = Math.sqrt(value);
 		System.out.println(ab);

		value =	(c.x - b.x)*(c.x - b.x) + (c.y - b.y)*(c.y - b.y);
		this.bc = Math.sqrt(value);
		System.out.println(bc);

		value =	(a.x - c.x)*(a.x - c.x) + (a.y - c.y)*(a.y - c.y);
		this.ca = Math.sqrt(value);
		System.out.println(ca);

		Side side = new Side();
		side.max(ab,bc,ca);
	}

			
	
}