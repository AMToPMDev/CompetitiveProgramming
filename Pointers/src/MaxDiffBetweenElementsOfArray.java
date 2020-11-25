/*
Given three sorted Arrays A,B,C and three pointers i,j,k pointing to elements in A,B,C respectively

We have to find minimum value for :
MAX(abs(A[i]-B[j]) , abs(B[j]-C[k]) , abs(C[k]-A[i]))

Method:
Find difference between max and min value among three pointers and then increment 
lowest value to minimize difference.
*/
public class MaxDiffBetweenElementsOfArray {

	public static void main(String[] args) {
		int i=0;
		int j=0;
		int k=0;
		int[] A = {2, 15, 20};
		int[] B = {10, 12};
		int[] C = {10, 15, 20};
		int ans = Integer.MAX_VALUE;
		int temp;
		
		while(i<A.length && j<B.length && k<C.length) {
			System.out.println("i : "+i);
			System.out.println("j : "+j);
			System.out.println("k : "+k);
			System.out.println("------");
			if((A[i] > B[j]) && (A[i] > C[k])) {
				temp = A[i];
			}
			else if(B[j] > C[k]) {
				temp = B[j];
			}
			else {
				temp = C[k];
			}
			
			
			if((A[i] < B[j]) && (A[i] < C[k])) {
				temp = temp - A[i];
				i++;
			}
			else if(B[j] < C[k]) {
				temp = temp - B[j];
				j++;
			}
			else {
				temp = temp - C[k];
				k++;
			}
			
			ans = (ans<temp)?ans:temp;
		}
		
		
		System.out.println("Minimum distance : "+ans);
	}

}
