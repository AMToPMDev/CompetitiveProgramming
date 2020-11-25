import java.util.Map;
import java.util.TreeMap;

/*
There are two arrays A, B as given below:
A: [1,3,5,1,9,5,2,8]
B: [5,3,2]

Sort array A as per array B, if some element is not present in array B,
then put them at the end in sorted order.

Answer:
A : [5,5,3,2,1,1,8,9]
B : [5,3,2]
*/
public class SortArrayAsPerSecondArray {
	
	public static void main(String args[]) {
		int[] A = {1,3,5,1,9,5,2,8};
		int[] B = {5,3,2};
		
		TreeMap<Integer, Integer> hs = new TreeMap<Integer, Integer>();
		
		for(int i=0; i<A.length; i++) {
			if(hs.containsKey(A[i])) {
				hs.put(A[i], hs.get(A[i])+1);
			}
			else {
				hs.put(A[i], 1);
			}
		}
		
		System.out.println("B : ");
		for(int i=0; i<B.length; i++) {
			System.out.print(B[i] + ",");
		}
		
		System.out.println("\nA : ");
		for(int i=0; i<B.length; i++) {
			if(hs.containsKey(B[i])) {
				for(int j=0; j<hs.get(B[i]); j++) {
					System.out.print(B[i] + ",");
				}
				hs.remove(B[i]);
			}
		}
		
		for(Map.Entry<Integer, Integer> element : hs.entrySet()) {
			for(int j=0; j<element.getValue(); j++) {
				System.out.print(element.getKey() + ",");
			}
		}
	}
		
}
