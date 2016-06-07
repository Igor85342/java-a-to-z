package zanaytie3;

public class Side{
	
	
	
	
	public boolean max(double ab, double bc, double ca) {

		boolean checkSide  = false;
		boolean checkSideone = maxtwo(ab,bc);
		boolean checkSidetwo = maxtwo(ab,ca);

		checkSide = checkSideone && checkSidetwo ? true : false ;
		
		return checkSide;
		
	}

	public boolean maxtwo(double ab, double bc){

		boolean checkSide = false;
		
		checkSide = ab >=bc ? true : false;	
		
		return checkSide;
	}
	
}