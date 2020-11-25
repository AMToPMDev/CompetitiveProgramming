package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given a maze of size NxM, there is a Kinght at point(x, y) and a target cell(a, b),
find the minimum number of move to reach the target.

Possible moves of Knight:
. -> move, k -> knight, * -> not a direct move

	0 1 2 3 4 5 6 7 8
	1 * * . * . * * * 
	2 * . * * * . * * 
	3 * * * K * * * *
	4 * . * * * . * * 
	5 * * . * . * * *
	6 * * * * * * * *
	7 * * * * * * * *
	8 * * * * * * * *

*/
class Location {
	int x;
	int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class minMovesToTargetByKnight {
	static int[][] visited;
	static int[][] distance;
	
	public static void bfs(Location start, Location target) {
		Queue<Location> q = new LinkedList();
		visited[start.x][start.y] = 1;
		int ans = 0;
		
		q.add(start);
		
		while(!q.isEmpty()) {
			Location l = q.poll();
			int x = l.x;
			int y = l.y;
			
			if(x-2>=0 && y-1>=0 && visited[x-2][y-1]==0) {
				q.add(new Location(x-2, y-1));
				distance[x-2][y-1] = distance[x][y]+1;
				visited[x-2][y-1] = 1;
				if(x-2==target.x && y-1==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
			if(x-2>=0 && y+1<8 && visited[x-2][y+1]==0) {
				q.add(new Location(x-2, y+1));
				distance[x-2][y+1] = distance[x][y]+1;
				visited[x-2][y+1] = 1;
				if(x-2==target.x && y+1==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
			if(x-1>=0 && y-2>=0 && visited[x-1][y-2]==0) {
				q.add(new Location(x-1, y-2));
				distance[x-1][y-2] = distance[x][y]+1;
				visited[x-1][y-2] = 1;
				if(x-1==target.x && y-2==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
			if(x-1>=0 && y+2<8 && visited[x-1][y+2]==0) {
				q.add(new Location(x-1, y+2));
				distance[x-1][y+2] = distance[x][y]+1;
				visited[x-1][y+2] = 1;
				if(x-1==target.x && y+2==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
			if(x+2<8 && y-1>=0 && visited[x+2][y-1]==0) {
				q.add(new Location(x+2, y-1));
				distance[x+2][y-1] = distance[x][y]+1;
				visited[x+2][y-1] = 1;
				if(x+2==target.x && y-1==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
			if(x+2<8 && y+1<8 && visited[x+2][y+1]==0) {
				q.add(new Location(x+2, y+1));
				distance[x+2][y+1] = distance[x][y]+1;
				visited[x+2][y+1] = 1;
				if(x+2==target.x && y+1==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
			if(x+1<8 && y-2>=0 && visited[x+1][y-2]==0) {
				q.add(new Location(x+1, y-2));
				distance[x+1][y-2] = distance[x][y]+1;
				visited[x+1][y-2] = 1;
				if(x+1==target.x && y-2==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
			if(x+1<8 && y+2<8 && visited[x+1][y+2]==0) {
				q.add(new Location(x+1, y+2));
				distance[x+1][y+2] = distance[x][y]+1;
				visited[x+1][y+2] = 1;
				if(x+1==target.x && y+2==target.y) {
					ans = distance[x][y]+1;
					break;
				}
			}
		}
		
		System.out.println("Number of moves: "+ans);
	}
	
	public static void main(String[] args) {
		Location start = new Location(0, 0);
		Location target = new Location(1, 0);
		
		visited = new int[8][8];
		distance = new int[8][8];
		
		bfs(start, target);
	}
}

