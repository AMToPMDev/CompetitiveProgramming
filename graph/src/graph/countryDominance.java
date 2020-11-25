package graph;

/*
Given two countries I and P where I is powerful than P.
Consider the area of both the countries is given in a matrix as below:

I I I I
I P P I
I I P I
I P I I

If country P's area is covered on four sides by I, I takes over P's land.
Find the resultant matrix where I takes over P's land.

Output:

I I I I
I I I I
I I I I
I P I I

Last P has not I on four sides so remains safe.

Hint: All the border P's and all P's connected to it will remain same rest will turn to I.

*/

public class countryDominance {
	static int[][] visited;
	
	public static void dfs(char[][] arr, int i, int j) {
		if(i==arr.length || j==arr[0].length || 
		   i==-1 || j==-1 || 
		   arr[i][j]=='I' || visited[i][j]==1) return;
		
		visited[i][j] = 1;
		
		arr[i][j] = 'C';
		
		dfs(arr, i-1, j); //up
		dfs(arr, i+1, j); //down
		dfs(arr, i, j-1); //left
		dfs(arr, i, j+1); //right
	}
	
	public static void main(String[] args) {
		char[][] arr = {{'I','I','P','I','I'},
						{'I','P','P','I','I'},
						{'I','I','I','I','P'},
						{'I','P','I','I','P'},
						{'I','P','P','I','P'},
						{'I','I','I','P','I'}};
		
		visited = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// DFS
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(i==0 || j==0 || i==arr.length-1 || j==arr[0].length-1) {
					if(arr[i][j]=='P') dfs(arr, i, j);
				}
			}
		}
		
		// Changing chars
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 'C') arr[i][j] = 'P';
				else if(arr[i][j] == 'P') arr[i][j] = 'I';
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
