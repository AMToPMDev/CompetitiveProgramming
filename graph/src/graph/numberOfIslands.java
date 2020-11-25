package graph;

import java.util.Arrays;

/*
Given a 2D matrix of 1s and 0s where 0 depicts water and 1 depicts land.
Find the number of islands is the matrix.
Island can be formed by adjoining 1s diagonally and perpendicularily

1 1 1 ---> 1 Island
1 1 1
1 1 1

Eg:
1 1 0 0 0
0 1 0 0 1
1 0 0 1 1
0 0 0 0 0
1 0 1 0 1

Ans: 5

*/

public class numberOfIslands {
	static int[][] visited;
	
	public static void dfs(int[][] arr, int i, int j) {
		// Base condition
		if(i==arr.length || j==arr[0].length || i==-1 || j==-1) return;
		else if(visited[i][j]==1 || arr[i][j]==0) return;
				
		visited[i][j] = 1;
		
		
		// Commented recursive calls are not needed,
		// as those paths will be covered by previous calls from main function
		
//		dfs(arr, i-1, j); //up
		dfs(arr, i+1, j); //down
//		dfs(arr, i, j-1); //left
		dfs(arr, i, j+1); //right
//		dfs(arr, i-1, j+1); //diagonally up-right
//		dfs(arr, i-1, j-1); //diagonally up-left
		dfs(arr, i+1, j+1); //diagonally down-right
		dfs(arr, i+1, j-1); //diagonally down-left
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0,0},
					   {0,1,0,0,1},
					   {1,0,0,1,1},
					   {0,0,0,0,0},
					   {1,0,1,0,1}};
		
		visited = new int[arr.length][arr[0].length];
		int ans = 0;		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]==1 && visited[i][j]==0) {
					ans++;
					dfs(arr, i, j);
				}
			}
		}		
		
		System.out.println("Number of Islands: "+ans);
	}
}
