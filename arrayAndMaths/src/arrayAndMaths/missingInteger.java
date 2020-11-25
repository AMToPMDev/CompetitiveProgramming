package arrayAndMaths;

/*
 
Array on length N contains 1 element which is present twice 
which in turn will mean 1 element is missing 

Find the missing and repeating element in O(n) time complexity

*/

public class missingInteger {
	public static void main(String args[]) {
		int sum = 0;
		long sqSum = 0;
		int[] arr = {1,2,3,3,5};
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			sum += arr[i];
			sqSum += (long)arr[i]*arr[i];
		}
		
		int actualSum = (n*(n+1))/2;
		int actualSqSum = (n*(n+1)*(2*n+1))/6;
		
		
		int mr_sub = actualSum - sum;
		long mt_sub_sq = actualSqSum - (long)sqSum;
		
		long mr_sum = (long)(mt_sub_sq/mr_sub);
		
		long m = (mr_sum+mr_sub)/2;
		long r = m-(long)mr_sub;
		
		System.out.println("Missing : "+m);
		System.out.println("Repeated : "+r);
	}
}
