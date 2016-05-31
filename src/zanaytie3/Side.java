package zanaytie3;

public class Side{
	
	
	
	
	public boolean max(double ab, double bc, double ca) {

		boolean checkSide  = false;
		boolean checkSideone = maxtwo(ab,bc);
		boolean checkSidetwo = maxtwo(ab,ca);
		if (checkSideone && checkSidetwo) {
			checkSide = true;	
		}
		return checkSide;
		
	}

	public boolean maxtwo(double ab, double bc){

		boolean checkSide = false;
			
		if (ab >=bc) {

			checkSide = true;
		}
		return checkSide;
	}
	
}