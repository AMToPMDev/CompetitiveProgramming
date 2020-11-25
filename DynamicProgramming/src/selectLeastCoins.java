/*
Given n different coin of different dimensions,
we have to achieve a given sum of rupees using least number of coins.
A coin can be picked any number of times.

Eg:
coins : [5, 10, 25]

Answer : 2 (25 and 5 can be picked once each)

*/
public class selectLeastCoins {
	public static int dp(int[] coins, int sum, int count) {
		if(sum<0) return Integer.MAX_VALUE;
		if(sum == 0) return count;
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<coins.length; i++) {
			min = Math.min(min, dp(coins, sum - coins[i], count+1));
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		int[] coins = {5,10,25};
		int sum = 45;
		
		System.out.println(dp(coins, sum, 0));
	}

}
