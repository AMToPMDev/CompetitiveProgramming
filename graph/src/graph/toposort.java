package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
Find the Topological sort is smallest lexographical order.
If topological sort does not exist, print "Topological Sort does not exist".

*/

public class toposort {
	static List<Integer>[] li;
	static int[] in;
	static List<Integer> ans;
	
	public static void kahn(int n) {
		// Priority Queue is to sort in increasing order.
		Queue<Integer> q = new PriorityQueue();
		
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
		
		// To check if topological sort exists or not, if there is a cycle topological sort won't exist.
		if(n == ans.size()) {
			System.out.println("Topological Sort: ");
			for(int k: ans) {
				System.out.println(k);
			}	
		}
		else {
			System.out.println("Topological Sort does not exist");
		}
	}
	
	private static void main(String args[]) {
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
