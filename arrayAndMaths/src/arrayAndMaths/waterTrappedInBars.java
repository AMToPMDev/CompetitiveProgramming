package arrayAndMaths;

/*

Array contains length of each bar placed on x-axis of graph,
if it rains on top of the bar what will be the quantity of water trapped
between them.

Eg: arr : [1,0,3]

Water trapped will be 1 unit on top of 0
  
     _
    | |
 _  | |
| |_| |
 1 0 3
*/

public class waterTrappedInBars {
	public static void main(String args[]) {
		int[] arr = {1,5,2,1,7,3};
		
		int[] ml = new int[arr.length];
		int[] mr = new int[arr.length];
		
		mr[arr.length-1] = -1;
		mr[arr.length-2] = arr[arr.length-1];
		
		for(int i=arr.length-2; i>=0;i--) {
			mr[i] = (mr[i+1]>arr[i+1])?mr[i+1]:arr[i+1];
		}
		
		ml[0]=-1;
		ml[1]=arr[0];
		
		for(int i=2; i<arr.length;i++) {
			ml[i] = (ml[i-1]>arr[i-1])?ml[i-1]:arr[i-1];
		}
		
		int ans=0;
		int temp;
		for(int i=0; i<arr.length; i++) {
			if(ml[i]>arr[i] && mr[i]>arr[i]) {
				temp = ((ml[i]<mr[i])?ml[i]:mr[i]) - arr[i];
				ans = ans + temp;
			}
		}
		
		
		
		System.out.println("Water trapped : "+ans);
	}
}
