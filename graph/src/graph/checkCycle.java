package graph;

import java.util.ArrayList;
import java.util.List;

/*
Given a graph, find whether it contains any cycle
*/

public class checkCycle {
	static int[] visited;
	
	public static boolean dfs(List<Integer>[] li, int i, int parent) {
		visited[i] = 1;
		
		boolean ans = true;
		
		for(int j: li[i]) {
			if(visited[j]==0) {
				 ans = ans&dfs(li, j, i);
			}
			else if(j!=parent) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{1,2},{2,3},{2,4},{3,4},{4,5}};
		
		List<Integer>[] li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList();
		}
		
		for(int i=0; i<edges.length; i++) {
			li[edges[i][0]].add(edges[i][1]);
			li[edges[i][1]].add(edges[i][0]);
		}
	
		boolean ans = true;
		visited = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(visited[i]==0) {
				ans = ans&dfs(li, i, 0);
			}
		}
		
		if(ans) System.out.println("Cycle don't exist");
		else System.out.println("Cycle Exists");
	}
}
