import java.util.Stack;

/*
Given a Matrix containing binary values.

0 1 0 1
1 1 0 1
1 1 1 0

Find the largest rectangle formed by 1's in matrix.

Answer: 2*2 = 4

Hint: Sum 1's per column, then for each row find maximum rectangle formed using stack implementation.
*/
public class BiggestRectangleInBinaryMatrix {

	public static void main(String[] args) {
		int[][] arr = {{0,1,0,1},
					   {1,1,0,1},
					   {1,1,1,0}};
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 1) {
					arr[i][j] = arr[i][j] + arr[i-1][j];
				}
			}
		}
		
		
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			
			Stack<Integer> temp = new Stack<Integer>();
			int[] prevMin = new int[arr[0].length];
			int[] nextMin = new int[arr[0].length];
			
			for(int j=0; j<arr[0].length; j++) {
				if(temp.size()!=0) {
					if(arr[i][j] > arr[i][temp.peek()]) {
						prevMin[j] = temp.peek();
						temp.push(j);
					}
					else {
						while((temp.size()>0) && (arr[i][temp.peek()]>arr[i][j])) {
							temp.pop();
						}
						if(temp.size()==0) {
							temp.push(j);
							prevMin[j] = -1;
						}
						else {
							prevMin[j] = temp.peek();
							temp.push(j);
						}
					}
				}
				else {
					temp.push(j);
					prevMin[j] = -1;
				}
			}
			
			temp = new Stack<Integer>();
			
			for(int j = arr[0].length-1; j>=0; j--) {
				if(temp.size()!=0) {
					if(arr[i][j] > arr[i][temp.peek()]) {
						nextMin[j] = temp.peek();
						temp.push(j);
					}
					else {
						while((temp.size()>0) && (arr[i][temp.peek()]>arr[i][j])) {
							temp.pop();
						}
						if(temp.size()==0) {
							temp.push(j);
							nextMin[j] = arr.length;
						}
						else {
							nextMin[j] = temp.peek();
							temp.push(j);
						}
					}
				}
				else {
					temp.push(j);
					nextMin[j] = arr.length;
				}
			}
			
			int sum;
			
			for(int j=0; j<arr[0].length; j++) {
				sum = nextMin[j] - prevMin[j] - 1;
				ans = (ans>(sum*arr[i][j]))?ans:(sum*arr[i][j]);
			}
		}
		
		System.out.println("Answer : "+ans);
	}
}
