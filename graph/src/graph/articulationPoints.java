package graph;

import java.util.*;

/*
Given a graph, find the articulation points.
Articulation points are points when removed will increase number of connected components.

Hint:
* Method is similar to finding bridges.
* If a node is root, if it has more than one children it is an articulation points

*/

public class articulationPoints {
	static List<Integer>[] li;
	static int[] visited;
	static int[] low;
	static int[] in;
	static int timer = 1;
	static HashSet<Integer> ans;
	
	public static void dfs(int curr, int parent) {
		visited[curr] = 1;
		low[curr] = timer;
		in[curr] = timer;
		int children = 0;
		timer++;
		
		for(int child: li[curr]) {
			if(child == parent) continue;
			else if(visited[child] == 1) {
				// This is a back edge
				low[curr] = Math.min(low[curr], in[child]);
			}
			else {
				// This is a forward edge
				children++;
				dfs(child, curr);
				low[curr] = Math.min(low[curr], low[child]);
				
				if(in[curr]<=low[child] && parent!=0) {
					ans.add(curr);
				}
			}
		}
		
		if(parent==0 && children>1) ans.add(curr);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int edges = s.nextInt();
		
		li = new ArrayList[n+1];
		ans = new HashSet<>();
		visited = new int[n+1];
		low = new int[n+1];
		in = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList();
		}
		
		for(int i=0; i<edges; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			li[a].add(b);
			li[b].add(a);
		}
		
		dfs(1, 0);
		
		System.out.println("Articulation Points");
		for(int key: ans) {
			System.out.println(key);
		}
	}
}






