
/*

Suppose you are given an array : [5, 8, 7, 2, 1, 9, 5]

Find the minimum subarray for which sum is greater than equal to given value k.

Eg:
I/P :   arr: [5,8,7,2,1,9,5]
		k: 14

O/P: 2 ([9,5] equals to 14)

Note:
Can be done in same time complexity using two pointers
*/
public class FindMaxSumOfSubArrayForUnsortedArray {

	public static void main(String[] args) {
		int input[] = {5, 8, 7, 2, 1, 9, 5};
		int k = 21;
		
		int n = input.length;
		int low = 0;
		int high = n-1;
		int mid = (high+low)/2;
		int max_subarray=0;
		int sum = 0;
		
		while(high>=low) {
			sum=0;
			
			mid = (high+low)/2;
			
			System.out.println("mid : "+mid);
			System.out.println("high : "+high);
			System.out.println("low : "+low);
			
			for(int i=0; i<mid; i++) {
				sum += input[i];
			}
			
			max_subarray = sum;
			
			for(int i=mid; i<n; i++) {
				sum = sum + input[i] - input[i-mid];
				max_subarray = (max_subarray>sum)?max_subarray:sum;
			}
			
			System.out.println("max_subarray : " + max_subarray);
			System.out.println("----------------");
			
			if(max_subarray > k)
				high = mid-1;
			else if(max_subarray < k)
				low = mid+1;
			else
				break;
		}
		
		System.out.println(mid);
	}
}
