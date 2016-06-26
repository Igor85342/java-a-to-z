package test1chapter;


public class SubstringTest{
	
	public static void main(String[] args){
	
	String origin = "one two three";
	String sub = "two";
	
	
	SubstringTest substringTest = new SubstringTest();
	boolean check = substringTest.contains(origin,sub);	
	System.out.println(check);
	}

	
	public boolean contains(String origin, String sub){

		char[] originArray = origin.toCharArray();
		char[] subArray = sub.toCharArray();
		boolean check = false;
		int controlNumber;
		for (int i = 0; i < originArray.length - subArray.length + 1; i++){
			
			controlNumber = 0;
			int g = 0;
			for (int j = 0 + i; j < subArray.length + i; j++){

				if (originArray[j] == subArray[g]){
					controlNumber ++;
					g++;
				}
			}
			
			if (controlNumber == subArray.length){

				check = true;
				break;
			}
		}
		return check;
	
	}
}