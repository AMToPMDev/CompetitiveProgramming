package graph;

import java.util.ArrayList;
import java.util.List;

/*
Given a tree, calculate in and out time of each node in it.

Note: This concept is used to check it 2 nodes are in each other's subtree in constant time.
*/

public class calculateInOutTimeOfNode {
	static int[] in;
	static int[] out;
	static int[] visited;
	static int timer=1;
	
	public static void dfs(List<Integer>[] li, int i) {
		visited[i] = 1;
		in[i] = timer;
		timer++;
		
		for(int j: li[i]) {
			if(visited[j]==0) dfs(li, j);
		}
		
		out[i] = timer;
		timer++;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{1,2},{2,3},{2,4}};
		
		List<Integer>[] li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList();
		}
		
		for(int i=0; i<edges.length; i++) {
			li[edges[i][0]].add(edges[i][1]);
			li[edges[i][1]].add(edges[i][0]);
		}
	
		visited = new int[n+1];
		in= new int[n+1];
		out= new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(visited[i]==0) {
				dfs(li, i);
			}
		}
		
		System.out.println("i:");
		for(int i=1; i<=n; i++) {
			System.out.print(i+" ");
		}
		System.out.println("\nin:");
		for(int i=1; i<=n; i++) {
			System.out.print(in[i]+" ");
		}
		System.out.println("\nout:");
		for(int i=1; i<=n; i++) {
			System.out.print(out[i]+" ");
		}
	}
}
