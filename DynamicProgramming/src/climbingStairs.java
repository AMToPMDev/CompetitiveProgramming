/*
Given n stairs with a person standing at the bottom,
person can climb single stair or 2 stairs a certain point.

Find the number of ways the person can reach at top.

Eg: 
n = 3

Possibilities: 1-2, 1-1-1, 2-1
Answer: 3

*/
public class climbingStairs {
	public static int dp(int n, int count) {
		if(n == count) return 1;
		if(n < count) return 0;
		
		return dp(n, count+1) + dp(n, count+2);
	}
	public static void main(String[] args) {
		System.out.println(dp(8,0));
	}
}
