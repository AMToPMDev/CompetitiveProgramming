package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
Given two 4 digit prime numbers say A and B, find minimum number of operations to convert A to B.
In one step you can change 1 digit of the number and the resulting number must also be a prime.

Input:
One line with a positive number: the number of test cases (at most 100). Then for each test case, 
one line with two numbers separated by a blank. Both numbers are four-digit primes (without leading zeros).

Eg:
Input:
3
1033 8179
1373 8017
1033 1033

Output:
6
7
0

Process: 
First find all the primes and store in a list.
Then make a adjacency list graph by iterating on the primes list and find all the graph connection.
Graph connection will be as per the question requirements.
Finally do a BFS from prime number 1 and find the distance to prime number 2.

*/

public class primePath {
	static List<Integer>[] li = new ArrayList[10000]; //As max 4 digit number can be 9999
	static List<Integer> primes = new ArrayList<>();
	static int[] visited = new int[10000];
	static int[] distance = new int[10000];
	
	// BFS to find the distance between two nodes
	public static void bfs(int i) {
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
	
	// Checking if a number is prime
	public static boolean isPrime(int n) {
		for(int i=2; i<Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	
	// To check if the connection between two nodes is valid
	public static boolean isValid(int a, int b) {
		int c=0;
		
		while(a>0) {
			if((a%10) != (b%10)) c++;
			a = a/10;
			b = b/10;
		}
		if(c==1) return true;
		else return false;
	}
	
	// For building graph 
	public static void buildGraph() {
		for(int i=1000; i<=9999; i++) {
			if(isPrime(i)) {
				primes.add(i);
			}
		}
		
		for(int i=0; i<primes.size(); i++) {
			for(int j=i+1; j<primes.size(); j++) {
				int a = primes.get(i);
				int b = primes.get(j);
				
				if(isValid(a, b)) {
					li[a].add(b);
					li[b].add(a);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		
		for(int i=1000; i<=9999; i++) li[i] = new ArrayList<>();
		
		buildGraph();
		int t = s.nextInt();
		
		while(t>0) {
			int num1 = s.nextInt();
			int num2 = s.nextInt();
			
			for(int i=1000; i<=9999; i++) {
				distance[i] = -1;
				visited[i] = 0;
			}
			
			bfs(num1);
			
			if(distance[num2]!=-1) System.out.println(distance[num2]);
			else System.out.println("Impossible");
			
			t--;
		}
	}
}
