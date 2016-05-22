package zanaytie3;

public class SideSquare{
	
	
	
	
	public boolean max(double ab, double bc, double cd, double da) {

		boolean checkSide  = false;

		if (ab >= bc && ab >= cd && ab >= da) {
			checkSide = true;	
		}
		return checkSide;
		
	}

	
}