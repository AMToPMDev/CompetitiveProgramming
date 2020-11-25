import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
You are given some integers in non-decreasing order and each time the median is queried
you have to report and remove it. Take the smaller elements as median in case of even elements.

On encountering -1, consider is query to find median.

I/P: 1 2 3 4 -1 -1 5 6 7 -1 0
O/P: 2 3 5 

Hint: Break array in two halves, store first half in stack as only elements will be pushed
and popped from one end and use queue to store second half.
*/
public class FindingMedianInStreamOfNumbers {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, -1, -1, 5, 6, 7, -1, 0};
		
		Stack<Integer> st = new Stack<Integer>();
		Queue<Integer> qu = new LinkedList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==-1) {
				System.out.print(st.pop() + ", ");
				
				if(qu.size()>st.size()) {
					st.push(qu.remove());
				}
			}
			else {
				qu.add(arr[i]);
				
				if(qu.size()>st.size()) {
					st.push(qu.remove());
				}
			}
		}
	}
}
