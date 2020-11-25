package arrayAndMaths;

import java.util.ArrayList;

/*

Find all the prime numbers present under a given value N.

Use sieve algorithm.
*/


public class primeNumbersSieveAlgo {
	public static void main(String args[]) {
		int n = 50;
		
		int[] arr = new int[n+1];
		
		ArrayList<Integer> result = new ArrayList<>();
		
		result.add(1);
		
		for(int i=2; i<=n; i++) {
			if(arr[i] == 0) {
				result.add(i);
				
				int j = i;
				
				while(i*j<=n) {
					arr[i*j] = 1;
					j++;
				}
			}
		}
		
		System.out.println(result);
	}
}
