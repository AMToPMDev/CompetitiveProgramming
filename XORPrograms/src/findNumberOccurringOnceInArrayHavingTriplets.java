
/*

Find the distinct number from array where numbers are repeated thrice

arr : [7,5,7,5,1,7,5]
o/p : 1

*/
public class findNumberOccurringOnceInArrayHavingTriplets {
	public static void main(String args[]) {
		int[] input = {7,5,7,5,10,7,5};
		
		int ans = 0;
		int c = 1;
		boolean flag=true;
		
		out:
		while(true) {
			flag = false;
			
			int count0 = 0;
			int count1 = 0;
			
			for(int i=0; i<input.length; i++) {
				if(input[i]%2 == 0) {
					count0++;
				}
				else {
					count1++;
					flag = true;
				}
				input[i] >>= 1;
			}
			
			System.out.println("count0 : "+count0);
			System.out.println("count1 : "+count1);
			System.out.println("ans1 : "+ans);
			if(flag) {
				if(count0 %3 == 0) {
					ans = ans | c;
				}
			}
			else {
				System.out.println("out");
				break out;
			}

			System.out.println("ans2 : "+ans);
			System.out.println("c : "+c);
			System.out.println("-----------");
			c *= 2;
		}
		
		System.out.println(ans);
		
	}
}
