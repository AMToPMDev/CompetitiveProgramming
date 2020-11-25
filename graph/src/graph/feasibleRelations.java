package graph;

import java.util.*;

/*
As a programmer, you sometimes have to deal with some math and this is the time to do it. 
You are given a list of binary relations, equalities and inequalities, like a = b, a != d, b = c etc. 
Your task is to output YES if you can assign integers to input variables in such a way, 
that you can satisfy all equalities and inequalities. Otherwise you should output NO.

Input format:
In the first line there is one integer T denoting the number of test cases. 
Description of T test cases follow. Each one have two integers N and K given in the first line denoting 
the number of variables and the number of relations between them for this test case. 
All variables are represented by integers in range [1, N]. K lines follow. 
Each of them is of the form "x1 R x2" where x1 and x2 are integers representing variables and 
R is either "=" or "!=" and denotes the kind of relation between these variables.

Input:
2
2 2
1 = 2
1 != 2
3 2
1 = 2
2 != 3

Output:
NO
YES
*/

public class feasibleRelations {
	static int[] visited;
	static List<Integer>[] li;
	static int[] cc;
	static int curr;
	
	public static void dfs(int i) {
		visited[i] = 1;
		cc[i] = curr;
		
		for(int child: li[i]) {
			if(visited[child]==0) dfs(child);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Pair> p;
		
		int t = s.nextInt();
		
		while(t>0) {
			int n = s.nextInt();
			int k = s.nextInt();
			
			li = new ArrayList[n+1];
			visited = new int[n+1];
			p = new ArrayList<>();
			cc = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				li[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<k; i++) {
				int a = s.nextInt();
				String op = s.next();
				int b = s.nextInt();
				
				if(op.equals("=")) {
					li[a].add(b);
					li[b].add(a);
				}
				else {
					p.add(new Pair(a,b));
				}
			}
			
			curr=0;
			for(int i=1; i<=n; i++) {
				if(visited[i] == 0) {
					curr++;
					dfs(i);
				}
			}
			
			boolean flag = true;
			for(int i=0; i<p.size(); i++) {
				if(cc[p.get(i).i] == cc[p.get(i).j]) 
					flag = false;
			}
			
			if(flag) System.out.println("YES");
			else System.out.println("NO");
			
			t--;
		}
	}
}
