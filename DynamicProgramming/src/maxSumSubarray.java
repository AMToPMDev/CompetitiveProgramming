/*
Given an array with n elements, find the maximum sum subarray.

Eg: 

arr: -2 -3 4 -1 -2 1 5 3

Ans: 10 (4 -1 -2 1 5 3) 

*/
public class maxSumSubarray {
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, 3};
		
		int curr_sum = 0;
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			curr_sum += arr[i];
			
			ans = Math.max(curr_sum, ans);
			
			if(curr_sum < 0) curr_sum=0;
		}
		
		System.out.println(ans);
	}
}
