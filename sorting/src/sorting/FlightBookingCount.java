package sorting;

/*

There are N flight numbered 1 to N.

Booking f flight has an input like (i, j, k), which implies k bookings in flight i to j.

Return array with number of seats booked in each flight.

Approach:
Use lazy propagation
*/

public class FlightBookingCount {

	public static void main(String[] args) {
		int N = 5;
		int[][] input = {{1,2,10},{2,3,20},{2,5,25}};
		
		int[] ans = new int[N];
		
		for(int i=0; i<input.length; i++) {
			ans[input[i][0] - 1] +=  input[i][2];
			
			if(input[i][1]<N) {
				ans[input[i][1]] -= input[i][2];
			}
		}
		
		for(int i=1; i<N; i++) {
			ans[i] += ans[i-1];
		}

		for(int i=0; i<N; i++) {
			System.out.println(ans[i]);
		}
	}
}
