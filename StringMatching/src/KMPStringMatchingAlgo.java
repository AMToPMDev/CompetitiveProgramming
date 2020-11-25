/*
Find if a pattern exists in a string using KMP Algorithm.
*/
public class KMPStringMatchingAlgo {
	public static void main(String[] args) {
		String str = "ajsdhadjadajdjsdafawegasjksdlkdsjfsa";
		String pattern = "djadajdjsda";
		int[] lps = new int[pattern.length()]; //longest possible suffix
		
		int i=1; //ahead pointer
		int j=0; //back pointer
		
		while(i<pattern.length() && j<pattern.length()) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = j+1;
				j++;
				i++;
			}
			else {
				if(j==0) {
					lps[i] = 0;
					i++;
				}
				else {
					j = lps[j-1];
				}
			}
		}
		
		i=0;
		j=0;
		
		while(i<str.length() && j<pattern.length()) {
			if(str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			else {
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
			
			if(j==pattern.length()) {
				System.out.println("Pattern found");
				
			}
		}
	}
}
