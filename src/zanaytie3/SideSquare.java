package zanaytie3;

public class SideSquare{
	
	
	
	
	public boolean max(double ab, double bc, double cd, double da) {

		boolean checkSide  = false;
		Side side = new Side();
		boolean checkSideone = side.maxtwo(ab,bc);
		boolean checkSidetwo = side.maxtwo(ab,cd);
		boolean checkSidethree = side.maxtwo(ab,da);
		
		checkSide = checkSideone && checkSidetwo && checkSidethree ? true : false ;
		
		return checkSide;
		
	}

	
}