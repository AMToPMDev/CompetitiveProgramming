package spoj;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeIntervals {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t>0) {
			int low = s.nextInt();
			int high = s.nextInt();
			
			ArrayList<Integer> ans = new ArrayList<>();
			
			
			int[] arr = new int[high+1];
			
			for(int i=2; i<=high; i++) {
				if(arr[i] == 0) {
					int temp = i*2;
					while(temp <= high) {
						arr[temp]=1;
						temp = temp+i;
					}
					if(i>=low)
						ans.add(i);
				}
			}
			
			for(Integer item : ans) {
				System.out.println(item);
			}
			
			t--;
		}
	}
}
