import java.util.Collections;
import java.util.PriorityQueue;

public class HeapApp {
	public static void main(String[] args) {
		int[] arr = {4,6,3,6,8,9,3,2,10,6,3};
		
		System.out.println("Min Heap");
		minHeap(arr);
		System.out.println("\nMax Heap");
		maxHeap(arr);
	}
	
	public static void minHeap(int[] arr) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			heap.add(arr[i]);
			System.out.println("Peek: "+heap.peek());
		}
		
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("Poll: "+heap.poll());
		}
	}
	
	public static void maxHeap(int[] arr) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<arr.length; i++) {
			heap.add(arr[i]);
			System.out.println("Peek: "+heap.peek());
		}
		
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("Poll: "+heap.poll());
		}
	}
}
