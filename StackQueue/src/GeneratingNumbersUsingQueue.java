import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an integer A. Find and return positive A integers in ascending order containing only digits 1,2,3.

Eg:
Input: 7
Output: 1,2,3,11,12,13,21

Hint: Use Queue
*/

public class GeneratingNumbersUsingQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new PriorityQueue<Integer>();
		int input = 8;
		
		q.add(1);
		q.add(2);
		q.add(3);
		
		int temp;
		
		for(int i=0; i<input; i++) {
			if(q.size()<input) {
				temp = q.remove();
				
				System.out.print(temp+", ");
				
				q.add(temp*10 + 1);
				q.add(temp*10 + 2);
				q.add(temp*10 + 3);
			}
			else {
				temp = q.remove();
				
				System.out.print(temp+", ");
			}
		}
	}
}
