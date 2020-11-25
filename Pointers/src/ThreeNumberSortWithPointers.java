/*
There is an array that contains 0,1,2 numbers of any count in unsorted order.

Sort this array in O(n) 
Without:
1. Using extra space
2. Using count 
3. In only one iteration

Hint : Use pointer method
*/

public class ThreeNumberSortWithPointers {

	public static void main(String[] args) {
		int[] arr = {1,0,0,1,2,0,1,2,0};
		
		int low = 0;
		int high = arr.length - 1;
		
		for(int i=0; i<arr.length && i<high; i++)
		{			
			if(arr[i] == 0) {
				arr = swap(arr, low, i);
				low++;
				if(arr[i] == 2) {
					arr = swap(arr, high, i);
					high--;
				}
			}
			else if(arr[i] == 2) {
				arr = swap(arr, high, i);
				high--;
				if(arr[i] == 0) {
					arr = swap(arr, low, i);
					low++;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "..");
		}
	}
	
	public static int[] swap(int[] arr,int a,int b) {
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
		return arr;
	}
}
