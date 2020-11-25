import java.util.Arrays;
import java.util.Comparator;

/*
There are n jobs each having a deadline and a profit associated with it.
Each job takes 1 day to complete and only one job can be ran in a day.
Find the maximum amount of profit that can be achieved.

Eg:
Id   deadline  Profit
a      4		 20
b	   1		 10
c	   1		 40
d	   1		 30


Output: 60 
Days: 1 2 3 4
Job : c * * a

Hint: Sort by profits descending, if profits are same sort by deadline ascending. 
*/

class sortJob implements Comparator<int[]>{
	@Override
	public int compare(int[] arg0, int[] arg1) {
		if(arg0[1] == arg1[1]) {
			if(arg0[0] > arg1[0]) return 1;
			else return -1;
		}
		else if(arg0[1] < arg1[1]) return 1;
		else return -1;
	}
}

public class jobScheduling {
	public static void main(String[] args) {
		int[][] arr = {{4,20},{1,10},{1,40},{1,30},{2,30}};
		
		Arrays.sort(arr, new sortJob());
		
//      Printing the list data...		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i][0] + ", " + arr[i][1]);
		}
		
		int[] used = new int[10];  //length should be max deadline
		
		int i=0;
		int sum = 0;
		while(i<arr.length) {
			int j = i;
			while(j>=0 && used[arr[i][0]] == -1) j--;
			
			if(j>=0) {
				System.out.println("i: "+i+", value: "+arr[i][1]);
				used[j] = -1;
				sum += arr[i][1];
			}
			i++;
		}
		
		System.out.println(sum);
	}
}
