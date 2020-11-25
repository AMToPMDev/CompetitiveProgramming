package hackerEarth;

import java.util.*;

public class PaintingBuildings {
	static ArrayList<Integer> exists = new ArrayList<>();
	static int speciality=0;
	
	public static void main(String[] args) {
		int[][] input = {{100,20},{30,50},{71,1},{9,200}};
		int[] painted = {0,0,0,2};
		int K = 2;
		speciality=K;
		
		for(int i=0; i<painted.length; i++) {
			exists.add(painted[i]);
		}
		
		int result=0;
		
		result = paint(input, 0, input.length, exists.get(input.length-1), 1);
	}
	
	public static int min(int i, int j) {
		return (i<j)?i:j;
	}
	
	public static int paint(int[][] input, int sum, int i, int j, int speciality) {
		
		if(i>=0) {
			if(exists.get(i)==0) {
				for(int c=0; c<input[0].length; c++) {
					sum += input[i][c];
					
					if(c!=j) {
						paint(input, sum, i-1,c,speciality+1);
					}
					else {
						paint(input, sum, i-1,c,speciality);
					}
				}
			}
			else {
				sum += input[i][exists.get(i)];
				
				if(j != exists.get(i))
					paint(input,sum,i-1,exists.get(i),speciality+1);
				else
					paint(input,sum,i-1,exists.get(i),speciality+1);
			}
		}
		return sum;
	}
}
