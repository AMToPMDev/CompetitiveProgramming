/*

There is given a number N = 7.

We have to find minimum base through which this number can be represented in form of sequence of 1's.

base >=2

Eg:
I/P : 7
O/P : (111) base(2)

I/P : 6
O/P : (11) base(5)

Approach:

If a number is represented in sequence of 1's, it is a G.P. of form:
1 + b + b^2 + b^3 + ... + b^(i-1) = N

where,
N = Input Number
b = base value
i = Number of 1's 

Using this we can derive the solution
*/

public class FindBaseWhereNumberIsRepresentedIn1 {

	public static void main(String[] args) {
		int input = 13;
		
		//as maximum digits will be present in base 2 we will use it as reference
		int temp = (int)Math.ceil(((Math.log(input))/(Math.log(2))));
		System.out.println("temp : "+temp);
		int mid = 0;
		
		out:
		for(int i=temp; i>=2; i--) {
				
			int high = input-1;
			int low = 2;			
			
			System.out.println("i-------------->"+i);
			while(high >= low) {
				mid = (high+low)/2;
				
				System.out.println("mid : "+mid);
				System.out.println("high : "+high);
				System.out.println("low : "+low);
				System.out.println("gp : "+gp(mid, i));
				
				if(gp(mid, i) > input) {
					high = mid-1;
				}
				else if (gp(mid, i) < input) {
					low = mid+1;
				}
				else {
					break out;
				}
				System.out.println("-----------------");
			}
		}
		
		System.out.println(mid);

	}
	
	static int gp(int b, int i) {
		return (int)(Math.pow(b, i) - 1)/(b-1);
	}

}
