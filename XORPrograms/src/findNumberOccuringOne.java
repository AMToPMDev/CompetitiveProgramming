

/*

From given array find the number who is present only once.

arr : [1,2,1,3,5,3,2]
o/p : 5

*/
public class findNumberOccuringOne {

	public static void main(String[] args) {
		int[] input = {1,2,1,3,5,3,2};
		
		int ans = 0;
		
		for(int i=0; i<input.length; i++) {
			ans = ans^input[i];
		}
		
		System.out.println(ans);
	}

}
