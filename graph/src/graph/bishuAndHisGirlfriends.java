package graph;

/*
There are N countries {1,2,3,4....N} and N-1 roads(i.e depicting a tree)
Bishu lives in the Country 1 so this can be considered as the root of the tree.

Now there are Q girls who lives in various countries (not equal to 1) and 
all of them want to propose Bishu.But Bishu has some condition.

He will accept the proposal of the girl who lives at minimum distance from his country.
Now the distance between two countries is the number of roads between them.

If two or more girls are at the same minimum distance then he will accept the proposal of the girl
who lives in a country with minimum id. No two girls are at same country.

Input:
6
1 2
1 3
1 4
2 5
2 6
4
5
6
3
4

Output: 3
*/
import java.util.*;

// CONCEPT IS SIMILAR TO Single Source Shortest Distance problem.
public class bishuAndHisGirlfriends {
	static int[] visited;
	static int[] distance;
	
	public static void dfs(List<Integer>[] li, int i, int d) {
		visited[i] = 1;
		distance[i] = d;
		
		for(int j: li[i]) {
			if(visited[j]==0) dfs(li, j, d+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		List<Integer>[] li = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			li[i] = new ArrayList();
		}
		
		for(int i=1; i<n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			li[a].add(b);
			li[b].add(a);
		}
		
		distance = new int[n+1];
		visited = new int[n+1];
		
		dfs(li, 1, 0);
		int min = Integer.MAX_VALUE;
		int ans = -1;
		int num_girls = s.nextInt();
		
		for(int i=0; i<num_girls; i++) {
			int girl_city = s.nextInt();
			
			if(distance[girl_city] < min) {
				min = distance[girl_city];
				ans = girl_city;
			}
			else if(distance[girl_city] == min && girl_city<ans) {
				ans = girl_city;
			}
		}
		
		System.out.println(ans);
	}
}
