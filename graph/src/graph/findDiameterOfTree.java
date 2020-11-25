package graph;

import java.util.ArrayList;
import java.util.List;

/*
Given a tree find the diameter/longest_path of the tree.
Diameter of a tree is the longest path of a tree.

Hint: 
Diameter of the tree can be find in 2 dfs calls:
i.  Find the farthest node from current node (current node can be taken as any node).
ii. Find the farthest node from the node you got from step i to get the diameter.

*/

public class findDiameterOfTree {
	static int[] visited;
	static int max_count = 0;
	static int farthest_node;
	
	public static void dfs(List<Integer>[] li, int i, int curr_count) {
		visited[i] = 1;
		
		if(curr_count>max_count) {
			farthest_node = i;
			max_count = curr_count;
		}
		
		for(int j: li[i]) {
			if(visited[j]==0) dfs(li, j, curr_count+1);
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{1,2},{2,3},{2,4},{1,5}};
				
		List<Integer>[] li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<edges.length; i++) {
			li[edges[i][0]].add(edges[i][1]);
			li[edges[i][1]].add(edges[i][0]);
		}
		
		visited = new int[n+1];
		dfs(li, 1, 0);
		
		visited = new int[n+1];
		dfs(li, farthest_node, 0);
		
		System.out.println("Diameter of the tree: "+max_count);
	}
}
