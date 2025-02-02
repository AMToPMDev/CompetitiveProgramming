package graph;

import java.util.ArrayList;
import java.util.List;

/*
Given a tree and a node, find shortest distance to each node from single source.

Input: 
	1-2-4-6   Source: 1
	|   |
	3   5
	
Output:

{1,2,3,4,5,6} : (0,1,1,2,3,3)
*/

public class singleSourceShortestDist {
	static int[] visited;
	static int[] distance;
	
	public static void dfs(List<Integer>[] li, int i, int d) {
		visited[i] = 1;
		
		distance[i] = d;
		
		for(int j: li[i]) {
			if(visited[j]==0) dfs(li, j, d+1);
		}
	}
	
	public static void main(String[] args) {
		int n=6;
		int[][] edges = {{1,2},{2,4},{1,3},{2,4},{4,5},{4,6}};
		List<Integer>[] li = new ArrayList[n+1];
		distance = new int[n+1];
		visited = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList();
		}
		
		for(int i=0; i<edges.length; i++) {
			li[edges[i][0]].add(edges[i][1]);
			li[edges[i][1]].add(edges[i][0]);
		}
		
		visited = new int[n+1];
			
		dfs(li, 1, 0);
		
		for(int i=1; i<=n; i++) {
			System.out.println("i: "+i+", distance: "+distance[i]);
		}
	}
}
