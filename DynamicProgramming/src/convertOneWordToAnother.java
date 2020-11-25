/*
Given two words, word1 and word2.
Convert word1 to word2 in minimum number of operations.

Operations that can be performed are:
1. Remove a char from A
2. Add a char in A
3. Replace a char in A

Eg:
word1: horse
word2: ros

Ans: 3

Opn 1: replacing h with r. (word: rorse)
Opn 2: removing 3rd char r (word: rose)
Opn 3: removing e (word: ros)



*/
public class convertOneWordToAnother {
	static int[][] values;
	public static int dp(String word1, String word2, int i, int j) {
		
		//Break condition
		if(i==word1.length() && j==word2.length()) 
			return 0;
		else if(i==word1.length()) 
			values[i][j] = word2.length() - j;
		else if(j==word2.length()) 
			values[i][j] = word1.length() - i;
		
		//Memoization
		if(values[i][j] != -1) return values[i][j];
		
		if(word1.charAt(i) == word2.charAt(j)) {
			values[i][j] = dp(word1, word2, i+1, j+1);
		}
		else {
			values[i][j] = 1 + Math.min(dp(word1, word2, i+1, j+1), 
										Math.min(dp(word1, word2, i, j+1),
												 dp(word1, word2, i+1, j))
										);
		}
		
		return values[i][j];
	}
	
	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		
		values = new int[word1.length()+1][word2.length()+1];
	
		for(int i=0; i<word1.length(); i++) {
			for(int j=0; j<word2.length(); j++) {
				values[i][j] = -1;
			}
		}
		
		System.out.println(dp(word1, word2, 0, 0));
	}
}
