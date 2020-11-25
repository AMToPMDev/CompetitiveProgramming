package hackerEarth;

import java.util.Scanner;

class Pair{
	int zero;
	int one;
	
	public Pair(int zero, int one) {
		this.zero = zero;
		this.one = one;
	}
}

public class binaryEquivalence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int[] zero = new int[n];
		int[] one = new int[n];
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		int max = findMax(arr);
		int size = findNums(max, -1).zero + findNums(max, -1).one;
		
		for(int i=0; i<n; i++) {
			Pair temp = findNums(arr[i], size);
			
			zero[i] = temp.zero;
			one[i] = temp.one;
		}
		
		int[] pre0 = new int[n+1];
		int[] pre1 = new int[n+1];
		
		pre0[0]=pre1[0]=0;
		
		for(int i=0; i<n;i++) {
			pre0[i+1] = pre0[i] + zero[i];
			pre1[i+1] = pre1[i] + one[i];
		}
		
		int count = 0;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=(n-i); j++) {
				if((pre0[j+i] - pre0[j]) == (pre1[j+i] - pre1[j])) {
					count++;
				}
			}
		}
		
		String out = "";
		
		while(count>0) {
			out = String.valueOf(count%2) + out;
			
			count = count/2;
		}
		
		while(out.length() <size) {
			out = "0"+out;
		}
		System.out.println(out);
	}
	
	public static Pair findNums(int value, int size) {
		int count_0 =  0;
		int count_1 =  0;
		
		while(value>0) {
			if(value%2 == 1) {
				count_1++;
			}
			else {
				count_0++;
			}
			
			value = value/2;
		}
		
		if(size != -1) {
			count_0 += size - (count_0 + count_1);
		}
		
		return new Pair(count_0, count_1);
	}
	
	public static int findMax(int[] arr) {
		int ret = Integer.MIN_VALUE;
		
		for(Integer e: arr) {
			ret = (ret>e)?ret:e;
		}
		return ret;
	}
}
