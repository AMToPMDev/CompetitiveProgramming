import java.util.ArrayList;
import java.util.Stack;

/*
Create a Min Stack which supports following operations:
pop(), push(), top(), getMin() 

Hint: We will store min value, on encountering value lesser than min we will change min value
and store 2*new_value - min as the value. While popping, if we encounter a value lesser than min
than it will mean that it is the value that changed min, so we will return the min as pop value 
ans change value of min = 2*old_min - top_value
*/

class MinStack{
	Stack<Integer> st = new Stack<Integer>();
	int min_value = Integer.MAX_VALUE;
	
	public int pop() {
		if(st.peek() < min_value) {
			int temp = min_value;
			
			min_value = 2*min_value - st.peek();
			st.pop();
			
			return min_value;
		}
		else{
			return st.pop();
		}
	}
	
	public void push(int value) {
		if(value<min_value) {
			st.push(2*value - min_value);
			min_value = value;
		}
		else {
			st.push(value);
		}
	}
	
	public int top() {
		if(st.peek() < min_value) {
			return min_value;
		}
		else {
			return st.peek();
		}
	}
	
	public int minValue() {
		return min_value;
	}
}

public class MinStackImplementation {

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		
		ms.push(5);
		ms.push(8);
		ms.push(10);
		
		System.out.println("Min value: "+ms.minValue());
		
		ms.push(2);
		
		System.out.println("Min Value: "+ms.minValue());
		System.out.println("Top: "+ms.top());
		
		ms.pop();
		
		System.out.println("Min Value: "+ms.minValue());
		System.out.println("Top: "+ms.top());
	}
}
