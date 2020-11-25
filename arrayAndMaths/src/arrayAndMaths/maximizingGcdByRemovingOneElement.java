package arrayAndMaths;


/*

Given an array of elements 
[12, 15, 18]   (Gcd : 3)

We can remove one element from the array and have to maximize the GCD

PS: Approach is bit similar to waterTrappedInBars
*/

public class maximizingGcdByRemovingOneElement {
	
	public static int gcd(int a, int b) {
		if(a==0)
			return b;
		else 
			return gcd(b%a, a);
	}
	
	public static void main(String[] args) {
		int[] input = {18, 24, 3};
		
		//We will find GCD from left and right and then to find GCD on removing
		//element, we will just find Gcd of its right suffix and left prefix
		
		int n = input.length;
		
		int[] prefix_gcd = new int[n];
		int[] suffix_gcd = new int[n];
		
		prefix_gcd[0] = input[0];
		for(int i=1; i<n; i++) {
			prefix_gcd[i] = gcd(input[i], prefix_gcd[i-1]);
		}
		
		suffix_gcd[n-1] = input[n-1];
		
		for(int i=n-2; i>=0; i--) {
			suffix_gcd[i] = gcd(input[i], suffix_gcd[i+1]);
		}
		
		int max = suffix_gcd[1];
		int temp;
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			System.out.println(prefix_gcd[i] + "..." + suffix_gcd[i]);
		}
		
		for(int i=1; i<n-1; i++) {
			temp = gcd(prefix_gcd[i-1], suffix_gcd[i+1]);
			
			if(temp>max) {
				ans = i;
				max = temp;
			}
		}
		
		temp = prefix_gcd[n-2];
		
		if(temp>max) {
			ans = n-1;
			max = temp;
		}
		
		System.out.println(input[ans] + "-->" + ans);
	}
}
