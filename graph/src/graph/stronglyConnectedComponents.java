package graph;

import java.util.*;

/*
Given a directed graph, find out the number of strongly connected components.

Eg:
7 8 (7 nodes, 8 edges)
1 2
2 3
3 1
4 3
7 4
7 5
5 6
6 7

Output: 3
Connected components:
5 7 6
4
1 3 2

*/

public class stronglyConnectedComponents {
	static int[] visited;
	static List<Integer>[] graph;
	static List<Integer>[] transpose;
	static List<Integer> out;
	
	// DFS done on actual graph to get the out time of all the nodes
	public static void dfs(int i) {
		visited[i] = 1;
		for(int child: graph[i]) {
			if(visited[child] == 0) dfs(child);
		}
		out.add(i);
	}
	
	// DFS done on the transposed graph as it's condensation graph will have zero out edges
	public static void dfs1(int i) {
		visited[i] = 1;
		System.out.print(i+" ");
		
		for(int child: transpose[i]) {
			if(visited[child] == 0) dfs1(child);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int edges = s.nextInt();
		
		visited = new int[n+1];
		out = new ArrayList();
		graph = new ArrayList[n+1];
		transpose = new ArrayList[n+1];
		
		// Initializing graphs
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList();
			transpose[i] = new ArrayList();
		}
		
		// Preparing graphs
		for(int i=0; i<edges; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			graph[a].add(b);
			transpose[b].add(a);
		}
		
		// Preparing out time on all the nodes
		for(int i=1; i<=n; i++) {
			if(visited[i] == 0) dfs(i);
		}
		
		Collections.reverse(out);
		visited = new int[n+1];
		
		for(int i: out) {
			if(visited[i] == 0) {
				System.out.println("\nNew component elements: ");
				dfs1(i);
			}
		}
	}
}
