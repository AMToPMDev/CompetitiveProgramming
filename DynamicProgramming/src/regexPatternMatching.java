import java.util.regex.PatternSyntaxException;

/*
Given a string containing chars from [a-z] and a pattern which contains [a-z], *, ? where:

? - It matches any character exactly once. (cannot represent empty string)
* - It matches any character any number of time. (empty string also) 

Check if the pattern matches the given string.

Eg:

String:  adceb
Pattern: *a*?b

Ans: Yes 

* - matches none
a - matches a
* - matches "dc"
? - matches e
b - matches b

*/
public class regexPatternMatching {
	static Boolean[][] values;
	
	public static char getChar(String s, int index) {
		if(index >= s.length()) return '~';
		else return s.charAt(index);
	}
	
	public static boolean dp(String str, String pattern, int i, int j) {
		// base conditions
		if(i==str.length() && j==pattern.length()) return true;
		else if(i==str.length()) {
			// Every char should be * 
			// This can be pre computed for better efficiency 
			for(int ind=j; ind<pattern.length(); ind++) {
				if(getChar(pattern, ind) != '*') return false;
			}
			return true;
		}
		else if(j==pattern.length()) {
			return false;
		}
		
		// Memoization
		if(values[i][j] != null) return values[i][j];
		
		
		// Dynamic programming logic
		if(getChar(str,i) != getChar(pattern, j)) {
			values[i][j] = false;
		}
		if((getChar(str,i) == getChar(pattern, j)) || (getChar(pattern, j) == '?')) {
			values[i][j] = dp(str, pattern, i+1, j+1);
		}
		else {
			//Condition where pattern char is *, either we consider it matches none or it matches one
			//recursive call will check the consideration of * matching more than one conditions as well.
			values[i][j] = dp(str, pattern, i+1, j)||dp(str, pattern, i+1, j+1);
		}
		
		return values[i][j];
	}
	
	public static void main(String[] args) {
		String str = "a";
		String pattern = "a*";
		
		values = new Boolean[str.length()][pattern.length()];
		
		System.out.println(dp(str, pattern, 0, 0));
	}
}
