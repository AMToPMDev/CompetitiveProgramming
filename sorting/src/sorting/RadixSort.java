package sorting;

/*

Used when range of number is less.  

*/

public class RadixSort {

	public static void main(String[] args) {
		int[] input = {20,11,3,4,5,1,50};
		
		for(int i :radixSort(input)) {
			System.out.println(i);
		}
	}
	
	public static int[] radixSort(int[] arr) {
		int max = getMax(arr);
		
		for(int exp=1; max/exp>0; exp = exp*10) {
			arr = countSort(arr, exp);
		}
		
		return arr;
	}
	
	public static int[] countSort(int[] arr, int exp) {
		
		int[] count = new int[10];
		int[] output = new int[arr.length];
		
		//counting digits
		for(int i=0; i<arr.length; i++) {
			count[(arr[i]/exp)%10]++;
		}
		
		//prefix sum
		for(int i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		
		//placing values ar sorted place
		for(int i=arr.length-1; i>=0; i--) {
			output[count[(arr[i]/exp)%10] - 1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		
		return output;
	}
	
	public static int getMax(int[] arr) {
		int max = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			max = (max>arr[i])?max:arr[i];
		}
		
		return max;
	}

}
