package graph;

/*
Given an unweighted undirectional graph, check whether is is a tree or not.

Input Format: First line contains two integers nodes (n) and edges (e) count. Next e line contains edges.

Output: Yes/No

Eg:

Input:
3 2
1 2
2 3

Output: YES

Hint: For a graph to be a tree it's number of connected components should be 1 and
      total edges should be n-1 where n is number of nodes.
*/

import java.util.*;

public class isTree {
	static int[] visited;
	
	public static void dfs(List<Integer>[] li, int i) {
		visited[i] = 1;
		
		for(int j: li[i]) {
			if(visited[j]==0) dfs(li, j);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int e = s.nextInt();
		
		List<Integer>[] li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			li[a].add(b);
			li[b].add(a);
		}
		
		int count = 0;
		visited = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(visited[i]==0) {
				dfs(li, i);
				count++;
			}
		}
		
		if(count==1 && e==n-1) System.out.println("YES");
		else System.out.println("NO");
	}
}
