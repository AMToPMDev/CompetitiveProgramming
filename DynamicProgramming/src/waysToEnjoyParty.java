/*
Assume a party is going on and a new person enters the party, he have two choices.
Either he can enjoy party alone or he can pair up with someone and enjoy the party.

Given a number n, find number of ways party can be enjoyed.

Eg:
n=1 [1] (1 way)
n=2 [1][2],[12] (2 ways)
n=3 [1][2][3],[12][3],[23][1],[13][2] (4 ways)

Hint:
Recursive equation:
f(n) = f(n-1) + (n-1)*f(n-2)

f(n-1) : if he wishes to enjoy alone then it would just be as much ways are previous.
(n-1)f(n-2) : There will be f(n-2) ways to pair up with (n-1) persons.

*/
public class waysToEnjoyParty {
	static int[] arr;
	public static int dp(int n) {
		if(arr[n] != 0) return arr[n];
		if(n <= 2) return n;
		
		arr[n] = dp(n-1) + (n-1)*dp(n-2);
		return arr[n];
	}
	
	public static void main(String[] args) {
		int n = 4;
		arr = new int[n+1];
		
		System.out.println(dp(n));
	}
}
