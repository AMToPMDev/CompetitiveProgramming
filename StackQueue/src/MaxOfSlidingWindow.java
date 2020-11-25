
import java.util.Deque;
import java.util.LinkedList;

/*
Given an array A and a window of size B which slides from left to right.
Print the maximum element in each window.

Window moves by 1 element each time.

arr: [1,3,-1,-3,5,3,6,7]
size: 3
o/p: [3,3,5,5,6,7]

Hint: Double sided queue will be used for solution.

*/
public class MaxOfSlidingWindow {

	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int size = 3;
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		//for adding first 3 elements
		for(int i=0; i<size; i++) {
			if(dq.size()!=0) {
				while((dq.size()>0) && (arr[dq.peekLast()] < arr[i])) {
					dq.removeLast();
				}
				dq.addLast(i);
			}
			else {
				dq.addLast(i);
			}
		}
		
		System.out.print(arr[dq.peekFirst()] + ", ");
		
		//for adding rest of the elements
		for(int i=size; i<arr.length; i++) {
			if((i - dq.peekFirst()) >= size) {
				dq.removeFirst();
			}
			
			while((dq.size()>0) && (arr[dq.peekLast()] < arr[i])) {
				dq.removeLast();
			}
			
			dq.addLast(i);
			
			System.out.print(arr[dq.peekFirst()] + ", ");
		}
	}
}
