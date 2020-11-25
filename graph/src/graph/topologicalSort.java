package graph;

import java.util.*;

/*
For a given graph, find the topological sort using Kahn's Algorithm.

Eg:
9 10
1 2
3 4
1 8
2 9
2 5
4 5
4 8
5 9
5 7
6 7

Output:
1 3 6 2 4 5 8 9 7
*/

public class topologicalSort {
	static List<Integer>[] li;
	static int[] in;
	static List<Integer> ans;
	
	public static void kahn(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			if(in[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			ans.add(curr);
			for(int k: li[curr]) {
				in[k]--;
				if(in[k] == 0) {
					q.add(k);
				}
			}
		}
		
		System.out.println("Topological Sort: ");
		for(int k: ans) {
			System.out.println(k);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int edges = s.nextInt();
		
		li = new ArrayList[n+1];
		in = new int[n+1];
		ans = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<>();
		}
		
		for(int i=0; i<edges; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			// This is one way edge
			li[a].add(b);
			in[b]++;
		}
		
		kahn(n);
	}
}
