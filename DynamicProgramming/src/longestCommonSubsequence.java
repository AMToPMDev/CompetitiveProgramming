/*
Given two strings, find the longest common subsequence between them.

Eg: 
A: "ABCDGH"
B: "AEDFHR"

Ans: "ADH"

Note:
This program can be done iteratively using a matrix
*/
public class longestCommonSubsequence {
	public static int LCS(String A, String B, int i, int j) {
		if(i<0 || j<0) return 0;
		
		//values can be memoized using a matrix to improve runtime
		
		if(A.charAt(i) == B.charAt(j)) 
			return 1 + LCS(A,B,i-1,j-1);
		else
			return Math.max(LCS(A, B,i-1,j), LCS(A, B,i,j-1));
	}
	public static void main(String[] args) {
		String A = "ABCDGH";
		String B = "AEDFHR";

		System.out.println(LCS(A,B,A.length()-1, B.length()-1));
	}
}
