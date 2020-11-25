/*
Given a Matrix, find possible number of paths from first cell to last cell,
given that you can only move down/right from a given point.

Eg:
Input: 2x2 matrix

Ans: 2 (down-right, right-down) 
*/
public class findPathInMatrixFromTopToBottom {
	static int c=0;
	public static int dp(int i, int j, int m, int n) {
		if(i+1==m && j+1==n) return 1;
		
		//values can be stored for memoization
		
		//IF THE QUESTION IS TO FIND MINIMUM COST, WE HAVE TO RETURN MINIMUM OF THE BOTH,
		//INSTEAD OF SUM.
		return (((i+1<m)?dp(i+1,j,m,n):0) + ((j+1<n)?dp(i,j+1,m,n):0));
	}
	
	public static void main(String[] args) {
		//dimensions of mxn matrix
		int m = 3;
		int n = 3;
		
		System.out.println("Total Paths: "+dp(0,0,m,n));
	}
}
