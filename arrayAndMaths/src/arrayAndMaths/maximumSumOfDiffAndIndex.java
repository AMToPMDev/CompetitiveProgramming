package arrayAndMaths;

/*

Program to return maximum of |A[i]-A[j]| + |i-j|
for a given array

*/

public class maximumSumOfDiffAndIndex {
	public static void main(String args[]) {
		int arr[] = {2,3,1,5,7};
		int max1=arr[0]+0;
		int max2=arr[0]+0;
		int min1=arr[0]+0;
		int min2=arr[0]+0;
		
		for(int i=1; i<arr.length; i++) {
			int a = Math.abs(arr[i]+i);
			max1 = (a>max1)?a:max1;
			min1 = (a<min1)?a:min1;
			
			int b = Math.abs(arr[i]-i);
			max2 = (b>max2)?b:max2;
			min2 = (b<min2)?b:min2;
		}
		
		int ans = ((max1-min1)>(max2-min2))?(max1-min1):(max2-min2);
		
		System.out.println("max1:"+max1);
		System.out.println("min1:"+min1);
		System.out.println("min2:"+min2);
		System.out.println("max2:"+max2);
		System.out.println("ans:"+ans);
	}
}
