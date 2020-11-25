package hackerEarth;

public class PaintingBuildingUsingLoops {
	static int[][][] dp;
	static int[] exists;
		
	public static void main(String[] args) {
		int[][] input = {{100,20},{30,50},{71,1},{9,200}};
		int[] painted = {0,0,0,2};
		int K = 2;
		
		exists = painted;
		dp = new int[input.length+1][input[0].length+1][K+1];
		
		System.out.println(dp[0].length);
		
		
		for(int i=0; i<input.length;i++) {
			if(exists[i] != 0) {
				for(int j=0; j<input[0].length; j++) {
					if(j!=(exists[i]-1)) {
						input[i][j] = Integer.MAX_VALUE;
					}
					else {
						input[i][j] = 0;
					}
				}
			}
		}
		
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				System.out.print(input[i][j] + ".");
			}
			System.out.println();
		}
		
		for(int i=0; i<input[0].length; i++) {
			dp[input.length-1][i][K] = input[input.length-1][i];
		}
//		if(exists[input.length-1]==0) {
//			for(int j=0; j<input[0].length; j++) {
//				dp[input.length-1][j][K] = input[input.length-1][j];
//			}
//		}
//		else {
//			for(int j=0; j<input[0].length; j++) {
//				dp[input.length-1][j][K] = Integer.MAX_VALUE;
//			}
//			dp[input.length-1][exists[input.length-1]-1][K] = input[input.length-1][exists[input.length-1]-1];
//		}
		
//		for(int j=0; j<input[0].length; j++) {
//			System.out.println("dp["+0+"]["+j+"][2]" + dp[input.length-1][j][2]);
//		}
		
		if(exists[input.length-1]!=0)
			paint(dp, input, input.length-1, exists[input.length-1]-1, K);
		else
			paint(dp, input, input.length-1, -1, K);
		
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				for(int k=0; k<K; k++) {
					System.out.println("dp["+i+"]["+j+"]["+k+"]" + dp[i][j][k]);
				}
			}
		}
	}
	
	public static void paint(int[][][] dp, int[][] input, int i, int j, int k) {
		
		if(k>0 && i>0) {
			for(int c=0; c<input[0].length; c++) {
				System.out.println("i : "+i+", j : "+j+", k : "+k+",c : "+c);
				
				if(c!=j) {
					if(dp[i-1][c][k-1]==0) {
						dp[i-1][c][k-1] = dp[i][j][k] + input[i-1][c];
						paint(dp, input, i-1,c,k-1);
					}
					else if(((dp[i][j][k] + input[i][j]) < dp[i-1][c][k-1])) {
						dp[i-1][c][k-1] = dp[i][j][k] + input[i-1][c];
						paint(dp, input, i-1,c,k-1);
					}
				}
				else {
					if(dp[i-1][c][k]==0) {
						dp[i-1][c][k] = dp[i][j][k] + input[i-1][c];
						paint(dp, input, i-1,c,k);
					}
					else if(((dp[i][j][k] + input[i][j]) < dp[i-1][c][k])) {
						dp[i-1][c][k] = dp[i][j][k] + input[i-1][c];
						paint(dp, input, i-1,c,k);
					}
				}
			}
		}
		
//		}
//		else if(k>0 && i>0) {
//			for(int c=0; c<input[0].length; c++) {
//				
//				if(exists[i]!=j) {
//					System.out.println("ii");
//					if(dp[i-1][exists[i]][k-1]==0) {
//						dp[i-1][exists[i]][k-1] = dp[i][j][k] + input[i][j];
//						paint(dp, input, i-1,exists[i]-1,k-1);
//					}
//					else if(((dp[i][j][k] + input[i][j]) < dp[i-1][exists[i]][k-1])) {
//						dp[i-1][exists[i]][k-1] = dp[i][j][k] + input[i][j];
//						paint(dp, input, i-1,exists[i]-1,k-1);
//					}
//				}
//				else {
//					System.out.println("jj");
//					if(dp[i-1][exists[i]][k-1]==0) {
//						dp[i-1][exists[i]][k] = dp[i][j][k] + input[i][j];
//						paint(dp, input, i-1,exists[i]-1,k);
//					}
//					else if(((dp[i][j][k] + input[i][j]) < dp[i-1][exists[i]][k-1])) {
//						dp[i-1][exists[i]][k] = dp[i][j][k] + input[i][j];
//						paint(dp, input, i-1,exists[i]-1,k);
//					}
//				}
//			}
	}
}
