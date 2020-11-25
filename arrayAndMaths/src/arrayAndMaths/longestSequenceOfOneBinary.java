package arrayAndMaths;

import java.util.Scanner;

/*

Find the longest sequence on 1's in a given binary number having a provision to swap 2 digits once

Eg:
Input : 11101101
After Swap : 11111100
Answer : 6

Input : 1111000
After swap: 1111000
Answer : 4

PS: Approach to solution is quite similar to waterTrappedInBars question
*/
public class longestSequenceOfOneBinary {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		String input = s.next();
		int n = input.length();
		
		int max_left[] = new int[input.length()];
		int max_right[] = new int[input.length()];
		
		
		max_left[0]=0;
		int count = 0;
		int countOne = 0;
		
		for(int i=0; i<n-1 ; i++) {
			if(input.charAt(i)=='1') {
				count++;
				max_left[i+1] = count;
			}
			else {
				count=0;
			}
			
			if(input.charAt(i)=='1') {
				countOne += 1;
			}
		}
		
		countOne += (int)input.charAt(n-1)-48;
		count=0;
		max_right[n-1]=0;
		for(int i=n-1;i>0;i--) {
			if(input.charAt(i)=='1') {
				count++;
				max_right[i-1] = count;
			}
			else {
				count=0;
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(max_left[i]+",");
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.print(max_right[i]+",");
		}
		System.out.println();
		
		int ans=0,temp;
		
		for(int i=0;i<n;i++) {
			temp = max_right[i] + max_left[i];
			
			ans = (ans>temp)?ans:temp;
		}
		
		if(countOne>ans)ans++;
		
		System.out.println("Answer: "+ans);
		
		s.close();
	}
}
