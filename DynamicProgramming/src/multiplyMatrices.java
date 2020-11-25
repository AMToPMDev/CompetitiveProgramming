/*
Given n matrices m1,m2,...,mn such that they can be multiplied with one another.
(m1 column should be equal to m2 row for multiplication to be possible)

Cost of multiplying m1(r1*c1) and m2(r2*c2) will be (r1*c1/r2*c2)

Try to multiply the n matrices wil minimum cost.

Eg: 

M1 : 10x30
M2 : 30x5
M3 : 5x60

Ans: 4500

When multiplied as (M1xM2)xM3, cost is:
(10*30*5) + (10*5*60) = 4500

If multiplied as M1x(M2xM3), cost is:

(10*30*60) + (30*5*60) = 27,000

*/

public class multiplyMatrices {
	static int[][] values;
	
	public static int dp(int[] rows, int[] columns, int i, int j) {
		if(i==j) return 0;
		
		if(values[i][j] != 0) return values[i][j];
		
		int min = Integer.MAX_VALUE;
		
		for(int k=i; k<j; k++) {
			//checking minimum of every possibility
			values[i][j] = Math.min(min, 
								(dp(rows, columns, i, k) + 
								 dp(rows, columns, k+1, j) + 
								 rows[i]*columns[k]*columns[j]
								) 
							);
		}
		
		return values[i][j];
	}
	
	public static void main(String[] args) {
		int[] rows = {10,30,5};
		int[] columns = {30,5,60};
		
		values = new int[rows.length][columns.length];
		
		System.out.println(dp(rows, columns, 0, rows.length-1));
	}
}
