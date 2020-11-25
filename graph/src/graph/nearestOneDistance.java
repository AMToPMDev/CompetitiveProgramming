package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a matrix with 0 and 1 in it, find the nearest distance of each zero to nearest 1.

Eg:
0 0 0 1
0 0 1 1
0 1 1 0

Output:
3 2 1 0 
2 1 0 0 
1 0 0 1

*/

class Pair {
	int i;
	int j;
	
	public Pair(int i, int j) {
		this.i=i;
		this.j=j;
	}
}

public class nearestOneDistance {	
	public static void main(String[] args) {
		int[][] arr = {{0,0,0,1},
					   {0,0,1,1},
					   {0,1,1,0}};
		
		int[][] visited = new int[arr.length][arr[0].length];
		Queue<Pair> q = new LinkedList<Pair>();
		int count = 1;
		
		// Printing initial matrix
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// Adding 1 nodes to queue
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 1) {
					q.add(new Pair(i, j));
					arr[i][j] = 0;
					visited[i][j] = 1;
				}
			}
		}
		
		
		q.add(null);
		
		// Checking each node in the matrix
		while(q.size()!=0 && q.peek() != null) {
			while(q.peek() != null) {
				Pair p = q.remove();
				
				if(p.i>0 && visited[p.i-1][p.j]==0) {
					visited[p.i-1][p.j] = 1;
					q.add(new Pair(p.i-1,p.j));
					arr[p.i-1][p.j] = count;
				}
				if(p.i+1<arr.length && visited[p.i+1][p.j]==0) {
					visited[p.i+1][p.j] = 1;
					q.add(new Pair(p.i+1,p.j));
					arr[p.i+1][p.j] = count;
				}
				if(p.j>0 && visited[p.i][p.j-1]==0) {
					visited[p.i][p.j-1] = 1;
					q.add(new Pair(p.i,p.j-1));
					arr[p.i][p.j-1] = count;
				}
				if(p.j+1<arr[0].length && visited[p.i][p.j+1]==0) {
					visited[p.i][p.j+1] = 1;
					q.add(new Pair(p.i,p.j+1));
					arr[p.i][p.j+1] = count;
				}
			}
			count++;
			q.remove();
			q.add(null);
		}
		
		// Printing the final matrix
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
