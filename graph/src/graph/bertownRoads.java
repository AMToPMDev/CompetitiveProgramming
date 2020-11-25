package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Bertown has n junctions and m bidirectional roads. We know that one can get from any junction to any 
other one by the existing roads.
As there were more and more cars in the city, traffic jams started to pose real problems. To deal with them 
the government decided to make the traffic one directional on all the roads, thus easing down the traffic. 
Your task is to determine whether there is a way to make traffic one-directional so that there still is the 
possibility to get from any junction to the other one. If the answer is positive, you should also find one 
of the possible ways to orient the roads.  

Note: Check if the town contains any bridges in the graph, if present it cannot be made one directional town.
*/

public class bertownRoads {
	static List<Integer>[] li = new ArrayList[101];
	static List<Pair> edgeList = new ArrayList<>();
	static int[] visited = new int[101];
	static int[] low = new int[101];
	static int[] in = new int[101];
	static int timer = 0;
	static boolean hasBridge = false;
	
	public static void dfs(int curr, int parent) {
		visited[curr] = 1;
		in[curr] = timer;
		low[curr] = timer;
		timer++;
		
		for(int child: li[curr]) {
			if(child == parent) continue;
			
			if(visited[child] == 1) {
				edgeList.add(new Pair(curr, child));
				low[curr] = Math.min(low[curr], in[child]);
			}
			else {
				// This is a forward edge
				dfs(child, curr);
				
				if(in[curr] < low[child]) {
					hasBridge = true;
				}
				edgeList.add(new Pair(curr, child));
				
				low[curr] = Math.min(low[curr], low[child]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int edges = s.nextInt();
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList();
		}
		
		while(edges > 0) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			li[a].add(b);
			li[b].add(a);
			edges--;
		}
		
		dfs(1, 0);
		
		if(hasBridge) {
			System.out.println("One directional bridges are not possible");
		}
		else {
			System.out.println("One directional bridges are: ");
			for(Pair p: edgeList) {
				System.out.println(p.i+"->"+p.j);
			}
		}
	}
}
