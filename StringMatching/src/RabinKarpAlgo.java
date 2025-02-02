import java.util.HashMap;

/*
Implement Rabin Karp Algorithm for Pattern matching in a string.

Uses HashMap approach
*/
public class RabinKarpAlgo {

	public static void main(String[] args) {
		String input = "aszjfabsdnfkjasndfkjabskksds";
		String pattern = "abs";
		
		int p = 5; //any prime number
		int value = 0;
		
		for(int i=0; i<pattern.length(); i++) {
			value += Math.pow(p, i)*(int)pattern.charAt(i);
		}
		
		int correct_hash = value;
		
		value = 0;
		
		for(int i=0; i<pattern.length(); i++) {
			value += Math.pow(p, i)*(int)input.charAt(i);
		}
		int low = 1;
		int high = pattern.length();
		
		//for first substring
		if(value == correct_hash && (pattern.equals(input.substring(low, high)))) {
			System.out.println("index : "+low);
			System.out.println("string : "+input.substring(low, high));
		}
		System.out.println("hash value : "+correct_hash);
		
		
		while(high<input.length()) {
			value = value - (int)input.charAt(low-1);
			value = value/p;
			
			value = (int) (value + input.charAt(high)*(Math.pow(p, (pattern.length()-1))));
			
			if(value == correct_hash && (pattern.equals(input.substring(low, high+1)))) {
				System.out.println("start index : "+low);
				System.out.println("string : "+input.substring(low, high+1));
			}
//			System.out.println("value : "+value);
//			System.out.println("low : "+low);
//			System.out.println("high : "+high);
//			System.out.println("----------------");
			low++;
			high++;
		}
	}
}