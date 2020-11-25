import java.util.ArrayList;
import java.util.List;

/*
Given a number n, find the number of ways in which a binary string of length n can be formed,
given that ones cannot be repeated.

Eg:
n = 3

Ans: 5 (000, 100, 010, 001, 101)

Hint: 
For n = 1, we have 0, 1 states
Now, for n=2, 0 can be added at end for all states, but 1 can be added only where last value was 0.

So, if a[] is 0's count and b[] is one's count, then

a[i] = a[i-1] + b[i-1] (as 0 can be added at all places)
b[i] = a[i-1]          (as 1 can only be added after zero)

and total states at i would be a[i]+b[i]
------------------------------------------- 
Note: Increment is in form of fibonacci series, so answer can be reached using that.
*/
public class binaryStringWithoutRepeatingOnes {
	public static void main(String[] args) {
		int n=7;
		
		List<Integer> a =  new ArrayList<>();
		List<Integer> b =  new ArrayList<>();
		
		a.add(0, 1);
		b.add(0, 1);
		
		for(int i=1; i<n; i++) {
			a.add(i, a.get(i-1) + b.get(i-1));
			b.add(i, a.get(i-1));
		}
		
		System.out.println("Total ways: "+(a.get(n-1) + b.get(n-1)));
	}
}
