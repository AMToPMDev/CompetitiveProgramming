package arrayAndMaths;

/*

There is a matrix which is in ascending order row wise and column wise.

matrix: 
10 20 30 40
15 25 35 45
16 30 37 50
19 33 39 52

We have to find a given number from the matrix.

*/

public class findNumberInIncrementalMatrix {
	public static void main(String args[]) {
		int[][] input = {{10,20,30,40},
						 {15,25,35,45},
						 {16,30,37,50},
						 {19,33,39,52}};
		
		int row = 0; 
		int column = input[0].length-1;  //finds length of column
		
		int value = 25;
		
		while(row<input.length && column>=0) {
			System.out.print(row + ":" + column + "-->");
			if(input[row][column] == value) {
				break;
			}
			else{
				if(input[row][column] > value) {
					column--;
				}
				else {
					row++;
				}
			}
			System.out.println(row + ":" + column);
		}
		
		System.out.println(row + ":::" + column);
	}
}
