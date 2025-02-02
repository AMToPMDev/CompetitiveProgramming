package graph;

import java.util.*;

/*
Given a weighted graph, find the shortest path from given node to all the other nodes.
Use Dijkstra's Algorithm to achieve the following.

Eg:
Input:
6 9
1 2 4
1 6 2
2 6 1
2 3 5
3 6 8
3 5 3
5 6 10
3 4 6
4 5 5

Output:
distance - {0, 3, 8, 14, 11, 2}
*/

public class dijkstraAlgoShortestPath {
	public static class Pair {
		int b, w;
		
		public Pair(int b, int w) {
			this.b = b;
			this.w = w;
		}
	}
	
	public static class sortPair implements Comparator<Pair> {
		@Override
		public int compare(Pair a, Pair b) {
			if(b.w > a.w) return 1;
			else return -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		TreeSet<Pair> pt = new TreeSet<Pair>(new sortPair());
		
		int n = s.nextInt();
		int e = s.nextInt();
		
		List<Pair>[] li = new ArrayList[n+1];
		int[] distance = new int[n+1];
		
		// Forming the graph
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList<Pair>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<e; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int w = s.nextInt();
			
			li[a].add(new Pair(b, w));
			li[b].add(new Pair(a, w));
		}
		
		pt.add(new Pair(1, 0));
		distance[1] = 0;
		
		while(!pt.isEmpty()) {
			Pair p = pt.pollFirst();
			int curr = p.b;
			int w = p.w;
			
			for(Pair pair: li[curr]) {
				if((pair.w + w) < distance[pair.b]) {
					distance[pair.b] = pair.w + w;
					pt.add(new Pair(pair.b, distance[pair.b]));
				}
			}
		}
		
		System.out.println("Distance from 1 Node: ");
		for(int i=1; i<=n; i++) {
			System.out.print(distance[i] + " ");
		}
 	}
}
