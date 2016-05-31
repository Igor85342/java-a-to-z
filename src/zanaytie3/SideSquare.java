package zanaytie3;

public class SideSquare{
	
	
	
	
	public boolean max(double ab, double bc, double cd, double da) {

		boolean checkSide  = false;
		Side side = new Side();
		boolean checkSideone = side.maxtwo(ab,bc);
		boolean checkSidetwo = side.maxtwo(ab,cd);
		boolean checkSidethree = side.maxtwo(ab,da);

		if (checkSideone && checkSidetwo && checkSidethree) {
			checkSide = true;	
		}
		return checkSide;
		
	}

	
}