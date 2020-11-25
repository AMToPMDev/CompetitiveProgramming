/*
Given a string(eg: "abcbaef"), find the number of characters to be inserted at start
to make string palindrome. 

Hint: Use KMP algorithm and find lps.
*/
public class NumberOfCharactersAtStartForPalindrome {

	public static void main(String[] args) {
		String str = "abcbaef";
		
		StringBuilder newString = new StringBuilder();
		StringBuilder reverse = new StringBuilder();
		
		newString.append(str);
		newString.append("$");
		
		reverse.append(str);
		reverse.reverse();
		
		newString.append(reverse);

		System.out.println(newString);
		
		int[] lps = new int[newString.length()];
		
		int i=1;
		int j=0;
		
		while(i<newString.length()) {
			if(newString.charAt(i) == newString.charAt(j)) {
				lps[i] = j+1;
				i++;
				j++;
			}
			else {
				if(j==0) {
					i++;
				}
				else {
					j = lps[j-1];
				}
			}
		}
		
		for(int c=0; c<newString.length(); c++) {
			System.out.print(lps[c]+",");
		}
		System.out.println("\nAnswer : "+(str.length() - lps[newString.length() - 1]));
	}

}
