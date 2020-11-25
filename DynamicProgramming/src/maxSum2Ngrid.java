/*
Given a 2xN grid with some values, find the maximum possible sum.
Given these conditions.
1. You cannot choose horizontally adjacent elements.
2. You cannot choose vertically adjacent elements.
3. You cannot choose diagonally adjacent elements.

Eg:
1 2 3 4
2 3 4 5 

Answer: 8 (Choosing 3 at [1][1] and 5 at [1][3])

Hint: From each column, we will be able to take the maximum element,
	  so finding max upfront will convert this problem to robbingHouses problem.
*/
public class maxSum2Ngrid {
	static int[] arr;
	
	public static int dp(int sum, int curr, int n) {
		if(curr > n) return 0;
		if(curr == n) return sum + arr[curr];
		
		return Math.max(dp(sum+arr[curr], curr+2, n), dp(sum+arr[curr], curr+3, n));
	}
	
	public static void main(String[] args) {
		int[][] input = {{1,2,3,4},{2,3,4,5}};
		arr = new int[input[0].length];
		
		for(int i=0; i<input[0].length; i++) {
			arr[i] = Math.max(input[0][i], input[1][i]);
		}
		
		int max = Math.max(dp(0, 0, arr.length-1), dp(0, 1, arr.length-1));
		
		System.out.println(max);
	}
}
