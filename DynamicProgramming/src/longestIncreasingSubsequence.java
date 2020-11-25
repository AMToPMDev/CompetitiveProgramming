/*
Given a sequence of numbers, 
find longest subsequence such that the numbers in subsequence are in increasing order.

Eg: 10 22 9 33 21 50 41 60 80

Ans: 6 (10,22,33,50,60,80)

*/

//Solved using Tabulation / Bottom up approach
public class longestIncreasingSubsequence {	
	public static void main(String[] args) {
		int[] arr = {10,22,9,33,21,50,41,60,80};
		
		int[] lis = new int[arr.length];
		for(int i=0; i<arr.length; i++) lis[i] = 1;
		
		int max = Integer.MIN_VALUE;
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if((arr[i] > arr[j]) && (lis[i] < lis[j] + 1)) {
					lis[i] = lis[j] + 1;
					max = Math.max(max, lis[i]);
				}
			}
		}
		
		System.out.println(max);
	}
}
