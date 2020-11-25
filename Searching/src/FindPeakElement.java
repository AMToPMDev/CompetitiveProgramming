
/*

Given an unsorted array with unique elements
arr : [1,2,15,3,10,12,20]

Peak element is defined as:

arr[i-1] <= arr[i] >= arr[i+1]

Find any one peak element in O(logn) time.
 
*/
public class FindPeakElement {
	public static void main(String[] args) {
		
		int[] input = {1,2,10,5,6,7,10};
		
		System.out.println(input[findPeak(input, 0, input.length-1)]);
	}
	
	
	static int findPeak(int[] input, int low, int high) {
		int mid = (low + high)/2;
		
		if(mid==0 || mid==input.length-1) {
			return mid;
		}
		
		if(input[mid]>=input[mid-1] && (input[mid] >= input[mid+1])) {
			return mid;
		}
		else if(input[mid+1] > input[mid-1]) {
			return findPeak(input, mid+1, high);
		}
		else {
			return findPeak(input, low, mid-1);
		}
	}
}
