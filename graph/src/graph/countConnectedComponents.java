package graph;

import java.util.List;
import java.util.ArrayList;

/*
Given n, i.e. total number of nodes in an undirected graph numbered from 1 to n and an integer e, 
i.e. total number of edges in the graph. Calculate the total number of connected components in the graph. 
A connected component is a set of vertices in a graph that are linked to each other by paths.

Input Format:
First line of input line contains two integers n and e. Next e line will contain two integers u and v 
meaning that node u and node v are connected to each other in undirected fashion. 

Output Format:
For each input graph print an integer x denoting total number of connected components.

Eg:
Input:
8 5
1 2
2 3
2 4
3 5
6 7

Output: 3

*/

public class countConnectedComponents {
	static int[] visited;
	
	public static void dfs(List<Integer>[] li, int i) {
		visited[i] = 1;
		
		for(int j: li[i]) {
			if(visited[j]==0) dfs(li, j);
		}
	}
	
	public static void main(String[] args) {
		int n = 7;
		int[][] edges = {{1,2},{2,3},{3,4},{3,5},{4,5},{4,6},{4,7},{5,6}};
		
		List<Integer>[] li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList();
		}
		
		for(int i=0; i<edges.length; i++) {
			li[edges[i][0]].add(edges[i][1]);
			li[edges[i][1]].add(edges[i][0]);
		}

//		for(int i=1; i<=n; i++) {
//			System.out.print("i: "+i+" -> ");
//			for(int j: li[i]) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		
		int count = 0;
		visited = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(visited[i]==0) {
				dfs(li, i);
				count++;
			}
		}
		
		System.out.println(count);
	}

}
