import java.util.HashMap;
import java.util.Map;

/*

Given an unsorted array of length n containing elements from 1->n.
We can make at max k swaps.

Find the maximum permutation for the array after k swaps.

Eg:
arr : [3,4,1,2,5]

If k=1:
ans : [5,4,1,2,3]

If k=2:
ans : [5,4,3,2,1]
*/
public class MaximumPermutationForOrderedArray {
	
	public static void main(String[] args) {
		int[] arr = {3,4,1,2,5};
		int n = arr.length;
		int k=2; 
		
		HashMap<Integer, Integer> hs = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			hs.put(arr[i], i);
		}
		
		int temp;
		int c = k;
		for(int i=n; i>=1; i--) {
			temp = hs.get(i);
			
			if(temp != (n-i)) {
				swap(arr, temp, (n-i));
				
				hs.put(arr[temp], temp);
				hs.put(arr[n-i], n-i);
				
				System.out.println("i : "+temp);
				System.out.println("n - i : "+(n-i));
				System.out.println("*************");
				c--;
			}
			
			if(c==0) {
				break;
			}
		}
		
		for(Map.Entry<Integer, Integer> element: hs.entrySet()) {
			System.out.println("key : "+element.getKey());
			System.out.println("Value : "+element.getValue());
			System.out.println("-----------");
		}
	}
	
	public static int[] swap(int[] arr, int a, int b) {
		int temp;
		
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
		return arr;
	}

}
