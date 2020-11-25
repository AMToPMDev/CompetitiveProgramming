package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a 2D matrix where 0 means empty, 1 means fresh orange and 2 means rotten orange.
Rotten orange can rot it's adjacent fresh orange in 1 time unit.
Find the amount of time needed to rot all the oranges.
If all the oranges can be rot then return -1;

Eg:
2 1 0 2 1
1 0 1 2 1
1 0 0 2 1

Output: 2

*/

// Pair class is built in nearestOneDistance and is reused here
public class rottenOranges {
	public static void main(String[] args) {
		int[][] arr = {{2,1,0,2,1},
					   {1,0,1,2,1},
					   {1,0,0,2,1}};
	
		int[][] visited = new int[arr.length][arr[0].length];
		Queue<Pair> q = new LinkedList<Pair>();
		int count = 0;
		
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
				if(arr[i][j] == 2) {
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
				
				if(p.i>0 && visited[p.i-1][p.j]==0 && arr[p.i-1][p.j]==1) {
					visited[p.i-1][p.j] = 1;
					q.add(new Pair(p.i-1,p.j));
					arr[p.i-1][p.j] = 2;
				}
				if(p.i+1<arr.length && visited[p.i+1][p.j]==0 && arr[p.i+1][p.j]==1) {
					visited[p.i+1][p.j] = 1;
					q.add(new Pair(p.i+1,p.j));
					arr[p.i+1][p.j] = 2;
				}
				if(p.j>0 && visited[p.i][p.j-1]==0 && arr[p.i][p.j-1]==1) {
					visited[p.i][p.j-1] = 1;
					q.add(new Pair(p.i,p.j-1));
					arr[p.i][p.j-1] = 2;
				}
				if(p.j+1<arr[0].length && visited[p.i][p.j+1]==0 && arr[p.i][p.j+1]==1) {
					visited[p.i][p.j+1] = 1;
					q.add(new Pair(p.i,p.j+1));
					arr[p.i][p.j+1] = 2;
				}
			}
			count++;
			q.remove();
			q.add(null);
		}
		
		// As last iteration didn't rot any oranges so decreasing its time.
		count--;
		
		boolean flag = true;
		
		out:
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 1) {
					flag = false;
					break out;
				}
			}
		}
		
		if(flag) System.out.println("Time taken: "+count);
		else System.out.println("All oranges not rotted");

		// Printing the final matrix
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
