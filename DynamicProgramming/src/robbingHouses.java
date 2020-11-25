/*
You are a robber in a city with sequence of houses.
Houses have a alarm system that if an adjacent house is robbed, 
it will trigger it's alarming system.

Your aim to rob maximum amount of money.

Eg:
Houses Money: 2 7 9 3 1

Answer: 12 (2 -> 9 -> 1)

*/
public class robbingHouses {
	static int[] arr = {2,7,9,3,1};
	
	public static int dp(int sum, int curr, int n) {
		if(curr > n) return 0;
		if(curr == n) return sum + arr[curr];
		
		return Math.max(dp(sum+arr[curr], curr+2, n), dp(sum+arr[curr], curr+3, n));
	}
	public static void main(String[] args) {
		int max = Math.max(dp(0, 0, 4), dp(0, 1, 4));
	
		System.out.println(max);
	}
}
