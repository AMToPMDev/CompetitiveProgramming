import java.util.Arrays;

/*
Given an unsorted array [2,4,3,1,5]

Find the pair whose XOR is minimum

Note:

If there are two number A<B,

A^X < A^B
and
X^B < A^B

So, everytime consecutive numbers will have minimum XOR
*/
public class findPairWithMinimumXOR {

	public static void main(String[] args) {
		int[] input = {3,5,6};
		//Sorting the array as consecutive numbers give minimum XOR
		Arrays.sort(input);
		
		int temp = Integer.MAX_VALUE;
		int ans = 0;
		
		for(int i=0;i<(input.length-1); i++) {
			if(temp > (input[i]^input[i+1])) {
				temp = input[i]^input[i+1];
				ans = i;
			}
		}
		
		System.out.println(input[ans] + "..." + input[ans+1]);
	}
}
