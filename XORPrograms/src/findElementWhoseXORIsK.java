import java.util.ArrayList;

/*
Find pair of numbers from given array whose XOR is equal to K

Use property a^b = k implies a = b^k
*/
public class findElementWhoseXORIsK {

	public static void main(String[] args) {
		int[] input = {5, 4, 10, 15, 7, 6};
		
		int k = 5;
		int a=-1,b=-1;
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i=0; i<input.length; i++) {
			if(al.contains(input[i])) {
				a = input[i];
				b = a^k;
				
				break;
			}
			
			al.add(input[i]^k);
		}
		
		System.out.println(a + "," + b);
	}
}
