package zanaytie3;

public class Side{
	
	
	
	
	public boolean max(double ab, double bc, double ca) {

		boolean checkSide  = false;

		if (ab >= bc && ab >= ca) {
			checkSide = true;	
		}
		return checkSide;
		
	}

	
}