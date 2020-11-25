import java.util.HashMap;

/*
Given an array, find the length of longest consecutive elements present in the array.

Eg:
[100,5,3,6,80,78,4,99]

Ans:
[3,4,5,6]
  
*/
public class MaxConsecutiveSeriesInUnsortedArray {

	public static void main(String[] args) {
		int[] arr = {100,5,3,6,80,78,4,99};
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++) {
			hs.put(arr[i],0);
		}
		
		int ans = 1;
		int temp;
		int count = 1;
		
		for(int i=0; i<arr.length; i++) {
			count = 1;
			temp = arr[i];
			
			if(!hs.containsKey(temp-1)) {
				while(hs.containsKey(temp+1)) {
					count++;
					temp++;
				}
			}
			ans = (ans>count)?ans:count;
		}
		
		System.out.println("Answer : "+ans);
	}
}
