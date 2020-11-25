/*
Given an encoded string which have decoding scheme as:
1-A, 2-B, 3-C, ... ,26-Z

Given the string, find number of ways the string can be decoded.

Eg:
Input : 121

Answer: 3 (ABA, LA, AU)

Recursive Function:

f(n) = f(n-1) + f(n-2)*

f(n-1) : If we decrypt the character an one character, no. of ways remains same as previous.
f(n-2) : This will be added if n-1 character and nth character form a valid string (<=26), 
		 in that case f(n-2) ways will be added to already formed f(n-1) ways.

*/
public class waysToDecodeString {
	public static int dp(int n, String encoded) {
		if(n<=0) return 1;
		
		System.out.println("str: "+encoded.substring(n-1, n+1));
		System.out.println((n-1)+".."+n);
		
		if(Integer.parseInt(encoded.substring(n-1, n+1))<=26) {
			return dp(n-1, encoded) + dp(n-2, encoded);
		}
		else return dp(n-1, encoded);
	}

	public static void main(String[] args) {
		String encoded = "121";
		
		System.out.println(dp(encoded.length()-1, encoded));
	}
}
