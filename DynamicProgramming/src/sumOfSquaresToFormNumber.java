import java.util.Arrays;

/*
Given a number try to represent that number on form of squares of smaller numbers.
i.e. 
100 -> 10*10
13  -> 3*3 + 2*2

Find the minimum number through which original number can be formed.

Hint: Maximum number can be sqrt(n), so if we form the array of elements using square of those numbers,
	  the problem gets reduced to selectLeastCoins problem.
*/
public class sumOfSquaresToFormNumber {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                j++;
            }
            dp[i] = min;
        }		
        return dp[n];
    }
    
//	INCORRECT SOLUTION-----------------
//    
//	static HashMap<Integer, Integer> hs = new HashMap<>();
//	
//	public static int dp(int[] arr, int sum, int count) {
//		if(sum<0) return Integer.MAX_VALUE;
//		if(sum == 0) return count;
//		
//		if(hs.containsKey(sum)) return hs.get(sum);
//		
//		int min = Integer.MAX_VALUE;
//		
//		for(int i=arr.length-1; i>0; i--) {
//			min = Math.min(min, dp(arr, sum - arr[i], count+1));
//			hs.put(sum, min);
//		}
//		
//		return min;
//	}
	
	public static void main(String[] args) {
//		int n = 48;
//		
//		int[] arr = new int[1 + (int)Math.sqrt(n)];
//		for(int i=1; i<arr.length; i++) {
//			arr[i] = i*i;
//		}
//		
//		System.out.println(dp(arr, n, 0));
		
		
		System.out.println(numSquares(48));
	}
}
