/*
Given a 2D matrix, find the maximum sum submatrix.

Eg:

Matrix:
 1  2 -1  -4 -20
-8 -3  4   2  1
 3  8  10  1  3
-4 -1  1   7  6

Ans:
39

-3  4   2  1
 8  10  1  3
-1  1   7  6 

*/
public class maxSumSubmatrix {
	public static void main(String[] args) {
		int arr[][] = {{1,2,-1,-4,-20},
					   {-8,-3,4,2,1},
					   {3,8,10,1,3},
					   {-4,-1,1,7,6}};
		
		int row = arr.length;
		int col = arr[0].length;
		
		// Finding prefix sum row wise first
		for(int i=0; i<row; i++) {
			for(int j=1; j<col; j++) {
				arr[i][j] += arr[i][j-1];
			}
		}
		
		// Printing prefix sub matrix 
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		int[] temp = new int[row];
		int ans = Integer.MIN_VALUE;
		int curr_sum=0;
		
		for(int i=0; i<col; i++) {
			for(int j=i+1; j<col; j++) {
				temp = new int[row];
				
				//Now forming an array out of all the row elements
				for(int k=0; k<row; k++) {
					temp[k] = arr[k][j];
					
					if(i>0) temp[k] -= arr[k][i-1];
				}
				
				//Finding max subarray (which will actually mean max sub matrix
				curr_sum=0;
				for(int k=0; k<row; k++) {
					curr_sum += temp[k];
					
					ans = Math.max(ans,	curr_sum);
					
					if(curr_sum < 0) curr_sum=0;
				}
			}
		}
		
		System.out.println("Ans: "+ans);
	}
}
