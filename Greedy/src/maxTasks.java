import java.util.Arrays;
import java.util.Comparator;

/*

Given n number of tasks with their start and end time in an array.
Find the maximum number of tasks you can perform.

Eg: 
Input: [[1,2],[3,4],[0,6],[5,7],[8,9],[5,9]]
Output: 4

1,2 -> 3,4 -> 5,7 -> 8,9 
*/
class sortTask implements Comparator<int[]>{
	@Override
	public int compare(int[] arg0, int[] arg1) {
		if(arg0[1] == arg1[1]) {
			if(arg0[0] > arg1[0]) return 1;
			else return -1;
		}
		else if(arg0[1] > arg1[1]) return 1;
		else return -1;
	}
}

public class maxTasks {
	public static void main(String[] args) {
		int[][] arr = {{1,2},{3,4},{0,6},{8,9},{5,7},{5,9}};
		
		//Sorting the array as per the ending time using Custom Comparator
		Arrays.sort(arr, new sortTask());
		
//      Printing the list data...		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i][0] + ", " + arr[i][1]);
//		}
		
		int count = 0;
		int i=0;
		
		while(i<arr.length) {
			int end = arr[i][1];
			count++;
			while(i<arr.length && end >= arr[i][0]) i++;
		}
		
		System.out.println(count);
	}
}
