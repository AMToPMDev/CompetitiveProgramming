/*
Given a sorted array and a value k, find possible pairs whose sum is equal to k.

Without:
1. Using extra space
2. In O(n) time

Hint : Use pointer method
*/

public class FindingPairsWithGivenSumUsingPointers {
	public static void main(String[] args) {
		int[] arr = {1,3,7,9,11,15,18,22};
		int k =  10;
		
		int low = 0;
		int high = arr.length-1;
		int sum = 0;
		
		while(low<high) {
			sum = arr[low] + arr[high];
			
			if(sum > k) {
				high--;
			}
			else if(sum < k) {
				low++;
			}
			else {
				System.out.println(arr[low]+".."+arr[high]);
				low++;
				high--;
			}
		}
	}
}
