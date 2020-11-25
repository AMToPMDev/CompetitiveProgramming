import java.util.Stack;

/*
Given a histogram, find the value of maximum histogram that can be formed through bars of histogram.

Eg:
Histogram:
       _
 _    | |
| |_  | |
| | |_| |
| | | | |
| | | | |
 4 3 2 5
 
Answer: 4*2 = 8 (where 4 is width and 2 is height)

Hint: Find previous min and next min using stacks and then find maximum rectangle each bar can form.
*/
public class MaxRectangleInHistogram {
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 5};
		
		Stack<Integer> temp = new Stack<Integer>();
		int[] prevMin = new int[arr.length];
		int[] nextMin = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			if(temp.size()!=0) {
				if(arr[i] > arr[temp.peek()]) {
					prevMin[i] = temp.peek();
					temp.push(i);
				}
				else {
					while((temp.size()>0) && (arr[temp.peek()]>arr[i])) {
						temp.pop();
					}
					if(temp.size()==0) {
						temp.push(i);
						prevMin[i] = -1;
					}
					else {
						prevMin[i] = temp.peek();
						temp.push(i);
					}
				}
			}
			else {
				temp.push(i);
				prevMin[i] = -1;
			}
		}
		
		temp = new Stack<Integer>();
		
		for(int i = arr.length-1; i>=0; i--) {
			if(temp.size()!=0) {
				if(arr[i] > arr[temp.peek()]) {
					nextMin[i] = temp.peek();
					temp.push(i);
				}
				else {
					while((temp.size()>0) && (arr[temp.peek()]>arr[i])) {
						temp.pop();
					}
					if(temp.size()==0) {
						temp.push(i);
						nextMin[i] = arr.length;
					}
					else {
						nextMin[i] = temp.peek();
						temp.push(i);
					}
				}
			}
			else {
				temp.push(i);
				nextMin[i] = arr.length;
			}
		}
		
		int ans = Integer.MIN_VALUE;
		int sum;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(prevMin[i]+", ");
		}
		System.out.println();
		for(int i=0; i<arr.length; i++) {
			System.out.print(nextMin[i]+", ");
		}
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			sum = nextMin[i] - prevMin[i] - 1;
			ans = (ans>(sum*arr[i]))?ans:(sum*arr[i]);
		}
		
		System.out.println("Answer: "+ans);
	}
}
