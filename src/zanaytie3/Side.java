package zanaytie3;

public class Side{
	
	public double ab;
	public double bc;
	public double ca;
	
	public static void main(String[] args){
		Point a = new Point(5,7);
		Point b = new Point(4,10);
		Point c = new Point(8,2);
		
		Side side = new Side();	
		
		side.ab = a.distanceTo(b);
 		side.bc = b.distanceTo(c);
		side.ca = c.distanceTo(a);

		if (side.max(side.ab,side.bc,side.ca)) {
			System.out.println("ab - max");	
		}

		
		if (side.max(side.bc,side.ca,side.ab)) {
			System.out.println("bc - max");	
		}

		
		if (side.max(side.ca,side.ab,side.bc)) {
			System.out.println("ca - max");	
		}

	}
		

	public boolean max(double ab, double bc, double ca) {
	
		return (maxtwo(ab,bc) && maxtwo(ab,ca)) ? true : false ;
		
	}

	public boolean maxtwo(double ab, double bc){
	
		return ab >=bc ? true : false;	
			
	}
	
}