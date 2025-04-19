package dataDrivenTesting;

public class RandomAlphanumaericData {

	public static void main(String[] args) {
		int n = 20;
		
		// choose a random character from this string
		String AlphanumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789abcdefghijklmnopqrsuvwxyz";
		
		// create String buffer size of alphanumeric String
		StringBuilder sb = new StringBuilder(n);
		
		for (int i = 0; i<n; i++) {
			
			//generate a random number between 0 to AlphaNumeric variable length
			
		int index = (int) (AlphanumericString.length()*Math.random());
		
		//add Character one by one in the end of sb
		sb.append(AlphanumericString.charAt(index));
			
		}
		System.out.println(sb);
		
	}
}
