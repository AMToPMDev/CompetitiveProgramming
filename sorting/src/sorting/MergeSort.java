package sorting;

/*

Implement Merge Sort

*/

public class MergeSort {

	public static void merge(int arr[], int left, int mid, int right) {
		
		int n1 = mid - left + 1; 
        int n2 = right - mid; 
		
		int[] l = new int[n1];
		int[] r = new int[n2];
		
		System.out.println("left : "+left+", right : "+right);
		
		int temp = left;
		
		for(int i=0; i<n1; i++) {
			l[i] = arr[left+i];
		}
		
		for(int i=0; i<n2; i++) {
			r[i] = arr[mid+i+1];
		}
		
		int i=0;
		int j=0;
		int k=left;
		
		while(i<n1 && j<n2) {
			if(l[i] > r[j]) {
				arr[k] = r[j];
				k++;
				j++;
			}
			else {
				arr[k] = l[i];
				i++;
				k++;
			}
		}
		
		while(i<n1) {
			arr[k] = l[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			arr[k] = r[j];
			k++;
			j++;
		}
		
		for(int m=0;m<10;m++) {
			System.out.print(arr[m] + ".");
		}
		System.out.println();
	}
	
	public static void mergeSort(int arr[], int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,3,1,5,7,6,8,10,9};
		mergeSort(arr,0,arr.length-1);
		
		for(Integer i: arr) {
			System.out.println(i+".");
		}
	}

}
