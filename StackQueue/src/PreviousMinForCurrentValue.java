import java.util.Stack;

/*
Create a stack which can return previous min_value w.r.t. current position.
If there is no previous element, return -1.
Eg:
stack values: [5,7,4,8,9,3]
prev min val: [-1,5,-1,4,8,-1]
*/
public class PreviousMinForCurrentValue {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> prevMinStack = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		
		int[] arr = {5,7,4,8,9,3};
		
		for(int i=0; i<arr.length; i++) {
			s1.push(arr[i]);
			
			if(temp.size()!=0) {
				if(arr[i] > temp.peek()) {
					prevMinStack.push(temp.peek());
					temp.push(arr[i]);
				}
				else {
					while((temp.size()>0) && (temp.peek()>arr[i])) {
						temp.pop();
					}
					if(temp.size()==0) {
						temp.push(arr[i]);
						prevMinStack.push(-1);
					}
					else {
						prevMinStack.push(temp.peek());
						temp.push(arr[i]);
					}
				}
			}
			else {
				temp.push(arr[i]);
				prevMinStack.push(-1);
			}
		}
		
		for(Object element: prevMinStack.toArray()) {
			System.out.print(element + ", ");
		}
		
	}
}
