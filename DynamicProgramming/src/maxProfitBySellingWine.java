/*
Suppose you are a wine seller in a Dry state and you can sell only one bottle of wine per year.
You have arranged the bottle in such a manner that you are able to reach only 2 bottles at a time.

Now, as the wine gets costlier with time, if you sell a bottle of wine after nth year, profit will be n*cost.

Given an array with cost of wine bottles where you are able to reach first and last bottle,
find the max profit you can generate.

Eg:
cost : 1 4 2 3

Ans: 29 (1*1 + 2*3 + 3*2 + 4*4, as year increase cost increases n times)

*/
public class maxProfitBySellingWine {
	public static int maxProfit(int[] cost, int i, int j, int year) {
		if(i>j) return 0;
		
		//values can be memoized to increase efficiency
		
		return Math.max(year*cost[j] + maxProfit(cost, i, j-1, year+1), 
						year*cost[i] + maxProfit(cost, i+1, j, year+1));
	}
	
	public static void main(String[] args) {
		int[] cost = {2,3,5,1,4};
		
		System.out.println("Max Profit: "+maxProfit(cost, 0, cost.length-1, 1));
	}
}
