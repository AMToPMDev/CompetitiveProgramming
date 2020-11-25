/*

Given an array where number are repeated twice apart from 2 numbers who occur only once.
arr: [1,3,1,3,5,6,7,7]

Find out the non repeating number from array in O(n) time without using extra space.

*/
public class findTwoNumberElementOccuringOneInArray {

	public static void main(String[] args) {
		int[] input = {1,3,1,3,5,6,7,7};
		int xor = 0;
		
		//finding xor of 2 distinct numbers
		for(int i=0; i<input.length; i++) {
			xor ^= input[i];
		}
		
		//xor of two numbers means bits are set at position where both the number's bits are different.
		//So, first we will find position at which bit is set in o/p using bitwise AND.
		int temp = 1;
		int c=0;
		
		while((temp&xor) == 0) {
			temp <<= 1;
			c++;
		}
		
		int num1=0;
		int num2=0;
		
		//Shifting c bits right will get the different bit at last position.
		//We can XOR all odd and even bits to get the different numbers.
		for(int i=0; i<input.length; i++) {
			if((input[i]>>c)%2 == 0) {
				num1 ^= input[i];
			}
			else {
				num2 ^= input[i];
			}
		}
		
		System.out.println("Num1 : "+num1);
		System.out.println("Num2 : "+num2);
	}

}
