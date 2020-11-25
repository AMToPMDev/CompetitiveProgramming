/*
Given n items having individual weight and profit attached to it.
Consider you have a knapsack which can carry W weight in it, 
find the maximum profit items you can carry given that 
you cannot carry more items than your knapsack weight limit W.

Eg:

profit : 60 60 100 120 
weight : 10 10 20  30

Ans: 240 (120 + 60 + 60)

*/
public class knapsackZeroOneProblem {
	static int[][] values; 
	
	public static int dp(int[] profit, int[] wt, int curr_wt, int max_wt, int index) {
		if(index == profit.length) return 0;
		
		if(values[index][curr_wt] != -1) return values[index][curr_wt];
		
		if((curr_wt + wt[index]) <= max_wt) {
			values[index][curr_wt] = Math.max(
											dp(profit, wt, curr_wt, max_wt, index+1),
											profit[index] + dp(profit, wt, curr_wt+wt[index], max_wt, index+1)
											);
		}
		else {
			values[index][curr_wt] = dp(profit, wt, curr_wt, max_wt, index+1);
		}
		
		return values[index][curr_wt];
	}
	
	public static void main(String[] args) {
		int[] profit = {60,60,100,120};
		int[] wt = {10,10,20,30};
		int max_wt = 50;
		
		//Space can be saved by using hashmap
		values = new int[profit.length][max_wt];
		
		for(int i=0; i<profit.length; i++) {
			for(int j=0; j<max_wt; j++) {
				values[i][j] = -1;
			}
		}
		
		System.out.println("Max Profit: "+dp(profit, wt, 0, max_wt, 0));
	}
}
