/*
Given two strings S1 and S2, find the number of subsequences in S1 which are equal to S2.

For eg:

S1: RABBBIT
S2: RABBIT

Ans: 3

RAB_BIT
RABB_IT
RA_BBIT

Underscore is char not considered
*/

public class countOfSubsequencesBetweenTwoWords {
	static int[][] values;
	
	public static int dp(String s1, String s2, int i, int j) {
		// base|break cases
		if(j==s2.length()) return 1;
		else if(i==s1.length()) return 0;
		
		if(values[i][j] != -1) return values[i][j];
		
		if(s1.charAt(i) != s2.charAt(j)) {
			values[i][j] = dp(s1, s2, i+1, j);
		}
		else {
			//either considering the comman element or not considering it.
			values[i][j] = dp(s1, s2, i+1, j) + dp(s1, s2, i+1, j+1);
		}
		
		return values[i][j];
	}
	
	public static void main(String[] args) {
		String s1 = "RABBBIT";
		String s2 = "RABBIT";
		
		values = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				values[i][j] = -1;
			}
		}
		
		System.out.println(dp(s1, s2, 0, 0));
	}
}
