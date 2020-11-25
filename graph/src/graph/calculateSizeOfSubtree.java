package graph;

import java.util.ArrayList;
import java.util.List;

/*
Given a tree, construct an array subsize[], where subsize[v] stores the size of subtree rooted at node v.
*/

public class calculateSizeOfSubtree {
	static int visited[];
	static int subsize[];
	
	static public int dfs(List<Integer>[] li, int i) {
		visited[i] = 1;
		int count = 1;
		
		for(int j: li[i]) {
			if(visited[j] == 0) {
				count += dfs(li, j);
			}
		}
		subsize[i] = count;
		
		return count;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{1,2},{2,3},{2,4}};
				
		List<Integer>[] li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<edges.length; i++) {
			li[edges[i][0]].add(edges[i][1]);
			li[edges[i][1]].add(edges[i][0]);
		}
		
		visited = new int[n+1];
		subsize = new int[n+1];
		
		dfs(li, 1);
		
		for(int i=1; i<=n; i++) {
			System.out.println("i: "+i+", size of subtree: "+subsize[i]);
		}
	}
}
