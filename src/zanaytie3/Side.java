package zanaytie3;

public class Side{
	
	
	
	
	public void max(double ab, double bc, double ca) {

		if (ab > bc && ab > ca) {
			System.out.println("ab - max");
		}
		else {
			if (bc > ab && bc > ca) {
				System.out.println("bc - max");	
			}
			else {
				if (ca > ab && ca> bc) {
					System.out.println("ca - max");		
				}
				else {
					if (ab == bc && ab > ca) {
						System.out.println("ab = bc - max");		
					}
					else {
						if (bc == ca && bc > ab) {
							System.out.println("bc = ca - max");
						}
						else {
							if (ca == ab && ca > bc) {
								System.out.println("ca = ab - max");
							}
							else {
								if (ab == bc && ab == ca){
									System.out.println("Ravnostoronnii treygolnik");
								}
							}
						}
					}
				}	

			}	
		}
	}

	
}