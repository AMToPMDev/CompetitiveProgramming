import java.util.Arrays;

/*

There are N stalls and there are xi number of locations where stalls can be placed

There are 2<=C<=N cows, where C depicts cows and N depicts number of stalls.

Now, the cows are aggressive and if they are kept near to each other they might start fighting.
So, we have to find the minimum distance between 2 cows as large as possible and also to fit all the 
cows in given stalls

Eg:
Stalls(N) : 5
Cows(C) : 3
Location at which stalls are present: [1,2,8,4,9]

Output: Cows can be placed at 1, 4, 9 so as to make minimum distance as 3
		So o/p is 3.


*/
public class AggressiveCows {

	public static void main(String[] args) {
		int N = 5;
		int C = 3;
		
		int[] stalls_loc = {1, 2, 8, 4, 9};
		
		Arrays.sort(stalls_loc);
		
		int high = stalls_loc[N-1];
		int low = stalls_loc[0];
		int mid=0;
		int count=0;
		int last=0;
		boolean flag = true;
		
		while(low<high) {
			mid = (high+low)/C; //as if number of cows are more, minimum distance will decrease between them
			count=1;
			last = stalls_loc[0];
			System.out.println("high : "+high);
			System.out.println("low : "+low);
			System.out.println("mid : "+mid);

			for(int i=1;i<N;i++) {
				if(stalls_loc[i] - last >= mid) {
					count++;
					last = stalls_loc[i];
				}
			}
			
			if(count>=C) {
				low = mid+1;
				flag = false;
			}
			else {
				high = mid-1; 
				flag = true;
			}
			
			System.out.println("end high: "+high);
			System.out.println("end low: "+low);
			System.out.println();
		}
		
		if(flag)
			System.out.println("Answer : " + (high+low)/2); 
		else
			System.out.println("Answer : " + mid);
	}

}
