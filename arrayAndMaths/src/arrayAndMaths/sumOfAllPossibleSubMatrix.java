package arrayAndMaths;

/*
  
There is a m*n matrix as given below

Matrix:
 1 2 3
 4 5 6
 7 8 9
 
Find sum of all the possible sub matrices.

Eg:
1 1
1 1

Sub Matrices:
[1]  ---> 4 times

[1]  [1 1]
[1]

[1 1]
[1 1]

Answer will be sum of all the above sub matrices formed from the matrix.
*/

public class sumOfAllPossibleSubMatrix {
	public static void main(String args[]) {
		int[][] input = {{1,2,3},
				    	 {4,5,6},
				    	 {7,8,9}};
		
		int sum=0;
		int p,q;
		
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				p = (i+1)*(j+1);
				q = (input.length-i) * (input[0].length-j);
				
				sum += p*q*input[i][j];
				System.out.print(p*q + ",");
			}
		}
		
		System.out.println(sum);
	}
}
