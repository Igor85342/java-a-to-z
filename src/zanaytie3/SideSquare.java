package zanaytie3;

public class SideSquare{
	
	
	public double ab;
	public double bc;
	public double cd;
	public double da;
	
	public static void main(String[] args){
		Point a = new Point(5,7);
		Point b = new Point(4,10);
		Point c = new Point(8,2);
		Point d = new Point(1,11);
		
		SideSquare sideSquare = new SideSquare();
		
		sideSquare.ab = a.distanceTo(b);
 		sideSquare.bc = b.distanceTo(c);
		sideSquare.cd = c.distanceTo(d);
		sideSquare.da = d.distanceTo(a);

		
		
		if (sideSquare.max(sideSquare.ab,sideSquare.bc,sideSquare.cd,sideSquare.da)) {
			System.out.println("ab - max(square)");	
		}

		
		
		if (sideSquare.max(sideSquare.bc,sideSquare.cd,sideSquare.da,sideSquare.ab)) {
			System.out.println("bc - max(square)");	
		}

		
		if (sideSquare.max(sideSquare.cd,sideSquare.da,sideSquare.ab,sideSquare.bc)) {
			System.out.println("cd - max(square)");	
		}

		
		if (sideSquare.max(sideSquare.da,sideSquare.ab,sideSquare.bc,sideSquare.cd)) {
			System.out.println("da - max(square)");	
		}
	}
	
	public boolean max(double ab, double bc, double cd, double da) {

		
		Side side = new Side();
		
		return side.maxtwo(ab,bc) && side.maxtwo(ab,cd) && side.maxtwo(ab,da) ? true : false ;
		
		
		
	}

	
}