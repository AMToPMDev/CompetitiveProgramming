/*
Given three strings s1, s2 and s3. Can you form string s3 by interleafing string s1 and s2
Interleafing is merging two string with preserving their order.

Eg:

s1: aabcc
s2: dbbca
s3: aadbbcbcac

Ans: True
*/
public class formStringUsingTwoStrings {
	public static char getChar(String s, int index) {
		if(index<0) return '~';
		else return s.charAt(index);
	}
	
	static Boolean[][] values; 
	
	public static boolean dp(String s1, String s2, String s3, int i, int j) {		
		int k = i+j+1;
		
		//to check if either or both of the strings is empty
		if(i==-1 && j==-1) {
			return true;
		}
		else if(i==-1 && j>=0) {
			if(getChar(s2,j)!=getChar(s3,k)) return false;
			else return dp(s1,s2,s3,i,j-1);
		}
		else if(i>=0 && j==-1) {
			if(getChar(s1,i)!=getChar(s3,k)) return false;
			else return dp(s1,s2,s3,i-1,j);
		}
		
		if(values[i][j] != null) return values[i][j];
		
		//if both are equal then OR the results
		//else move on with the matched char
		//else return false
		if(getChar(s1,i)==getChar(s3,k) && getChar(s2,i)==getChar(s3,k)) {
			values[i][j] = (dp(s1,s2,s3,i-1,j)||dp(s1,s2,s3,i,j-1));  
		}
		else if(getChar(s1,i)==getChar(s3,k) && getChar(s2,j)!=getChar(s3,k)) {
			values[i][j] = dp(s1,s2,s3,i-1,j);
		}
		else if(getChar(s1,i)!=getChar(s3,k) && getChar(s2,j)==getChar(s3,k)) {
			values[i][j] = dp(s1,s2,s3,i,j-1);
		}
		else values[i][j] = false;
		
		return values[i][j];
	}
	
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		values = new Boolean[s1.length()][s2.length()];
		
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				values[i][j] = null;
			}
		}
		
		if((s1.length() + s2.length()) != s3.length()) System.out.println("False");
		else System.out.println("Ans: "+dp(s1, s2, s3, s1.length()-1, s2.length()-1));
	}
}
