package graph;

import java.util.*;
/*
In a social networking site, people are connected with other people. The whole system appears as a giant 
connected graph. In this question, you are required to answer the total number of people connected at 
t nodes away from each other (t distance connectivity). For example: Two persons directly connected are at 
1 distance connectivity. While the two persons having a common contact without having direct connectivity, 
are at 2 distance connectivity.

Input Format:
First line of input line contains, two integers n and e, where n is the nodes and e are the edges. 
Next e line will contain two integers u and v meaning that node u and node v are connected to each other 
in undirected fashion. Next line contains single integer, m, which is number of queries. Next m lines, 
each have two inputs, one as source node and other as a required t distance connectivity which should be 
used to process query.

Note: The index of nodes will be 0-based. The example and the test case shown is of 1-based index. 
For submitting the solution, use 0-based indexing.

Input:
9 10
1 2
2 3
1 7
2 4
3 4
4 7
7 8
9 7
7 6
5 6
3
4 2
5 3
2 1

Output: 
4 
4
3
*/

public class socialNetwork {
	static int[] visited;
	static int[] distance;
	static int[] count;
	static List<Integer>[] li;
	
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		distance[i] = 0;
		count[distance[i]]++;
		visited[i] = 1;
		q.add(i);
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			
			for(int child: li[parent]) {
				if(visited[child] == 0) {
					visited[child] = 1;
					distance[child] = distance[parent] + 1;
					count[distance[child]]++;
					q.add(child);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int e = s.nextInt();
		
		li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) li[i] = new ArrayList<Integer>();
		
		while(e>0) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			li[a].add(b);
			li[b].add(a);
			e--;
		}
		
		int query = s.nextInt();
		
		while(query>0) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			visited = new int[n+1];
			distance = new int[n+1];
			count = new int[n+1];
			
			bfs(a);
			
			System.out.println(count[b]);
			
			query--;
		}
	}
}
