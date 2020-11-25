package arrayAndMaths;

/*
Given an array in Unsorted form.
Find the maximum difference between consecutive elements if arranged
in sorted format.

Eg: arr: [1, 10, 5]
arr_sorted: [1,5,10]
differences: [4,5]
Max_diff : 5
*/

public class maxDifferenceInSortedFormGivenUnsortedArray {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		int[] arr = {1,10,5};
		int len = arr.length;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		int[] max_buk = new int[len];
		int[] min_buk = new int[len];
		
		for(int i=0; i<len; i++) {
			max = (max>arr[i])?max:arr[i];
			min = (min<arr[i])?min:arr[i];	
			
			max_buk[i] = Integer.MIN_VALUE;
			min_buk[i] = Integer.MAX_VALUE;
		}
		
		int gap = (max - min)/len;
		int temp;
		
		for(int i=0; i<len;i++) {
			temp = (arr[i]-min)/(gap+1);
			
			max_buk[temp] = (max_buk[temp]>arr[i])?max_buk[temp]:arr[i];
			min_buk[temp] = (min_buk[temp]<arr[i])?min_buk[temp]:arr[i];
		}
		
		int ans = 0;
		int buf;
		if(len>2) {
			temp = max_buk[0];
			
			for(int i=1;i<len;i++) {
				if(min_buk[i]!=Integer.MAX_VALUE) {
					buf = min_buk[i] - temp;
					temp = max_buk[i];
					
					ans = (ans>buf)?ans:buf;
				}
			}
		}
		
		System.out.println("Answer : "+ans);
	}
}
