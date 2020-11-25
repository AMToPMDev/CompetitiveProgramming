package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/* 
Monk visits the land of Islands. There are a total of N islands numbered from 1 to N. 
Some pairs of islands are connected to each other by Bidirectional bridges running over water.
Monk hates to cross these bridges as they require a lot of efforts.
He is standing at Island #1 and wants to reach the Island #N. 
Find the minimum the number of bridges that he shall have to cross, if he takes the optimal route.

Input:
First line contains T. T testcases follow.
First line of each test case contains two space-separated integers N, M.
Each of the next M lines contains two space-separated integers X and Y, 
denoting that there is a bridge between Island X and Island Y.

Eg:
1
3 2
1 2
2 3

Output: 2

*/
public class monkAndTheIslands {
	static int[] visited;
	static int[] distance;
	
	public static void bfs(List<Integer>[] li, int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[i] = 1;
		distance[i] = 0;
		q.add(i);
		
		int c = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int child: li[curr]) {
				if(visited[child]==0) {
					q.add(child);
					distance[child] = distance[curr]+1;
					visited[child] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t>0) {
			int n = s.nextInt();
			int edges = s.nextInt();
			List<Integer>[] li = new ArrayList[n+1];
			
			for(int i=1; i<=n; i++) {
				li[i] = new ArrayList<Integer>();
			}
	
			for(int i=0; i<edges; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				li[a].add(b);
				li[b].add(a);
			}
			
			visited = new int[n+1];
			distance = new int[n+1];
			
			bfs(li, 1);
			
			System.out.println(distance[n]);
			
			t--;
		}
	}
}
