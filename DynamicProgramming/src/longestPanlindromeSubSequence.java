/*
Given a string, find the length of longest possible subsequence of it which is also a palindrome.

Eg: 
String = "AGBDBA"

Ans = 5 ("ABDBA")

Note: One method is reversing the given string and finding LCS to get the answer.

*/
public class longestPanlindromeSubSequence {
	public static int PalinLCS(String str, int low, int high) {
		if(low>high) return 0;
		if(low == high) return 1;
		
		// values can be memoized to a 2D matrix of size len(str)*len(str)
		if(str.charAt(low) == str.charAt(high))
			return 2 + PalinLCS(str, low+1, high-1);
		else
			return Math.max(PalinLCS(str, low+1, high), PalinLCS(str, low, high-1));
	}
	
	public static void main(String[] args) {
		String str = "AGBDBA";
		
		System.out.println(PalinLCS(str, 0, str.length()-1));
	}
}
