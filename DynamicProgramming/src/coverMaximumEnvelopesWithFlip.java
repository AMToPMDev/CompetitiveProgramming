import java.util.Arrays;

/*
This question is extension to coverMaximumEnvelopes....

Given n envelopes with height and width in an array.
Find the maximum number of envelopes you can stack one inside another.
Envelope can only be stacked if height and width are strictly smaller.
Envelopes can be flipped, means height becomes width and vice versa.


Eg:

Height : 1 9 5  
Width  : 7 4 10

Ans: 3

    F
1 < 4 < 5
7 < 9 < 10

2nd envelope is flipped

Note: This problem can be solved by making 2n envelopes by flipping all n envelopes. 
	  Then using coverMaximumEnvelopes technique. 
*/


//Envelope class and sortEnvelopes comparator are defined in coverMaximumEnvelopes

public class coverMaximumEnvelopesWithFlip {
	public static void main(String[] args) {
		int[] height = {1,9,5};
		int[] width = {7,4,10};
		int max = Integer.MIN_VALUE;
		int len = height.length;
		
		//creating and sorting envelopes based on area
		Envelope[] e = new Envelope[len];
		for(int i=0; i<len; i++) {
			e[i] = new Envelope(height[i], width[i]);
		}
		
		Arrays.sort(e, new sortEnvelopes());
		
		int[][] lis = new int[len][2];
		//lis[i][0] denotes unflipped, lis[i][1] denotes flipped
		for(int i=0; i<len; i++) {
			lis[i][0] = 1;
			lis[i][1] = 1;
		}
		
		//maximum of flipped and unflipped version will be taken
		for(int i=1; i<len; i++) {
			//max will be taken by considering when ith envelope is:
			//flipped on flipped
			//flipped on unflipped
			//and
			//unflipped on flipped
			//unflipped on unflipped
			for(int j=0; j<i; j++) {
				//checking for unflipped i
				lis[i][0] = Math.max(
								(e[i].height>e[j].height && e[i].width>e[j].width && lis[i][0]<lis[j][0]+1)?
										(lis[j][0]+1):lis[i][0],
								(e[i].height>e[j].width && e[i].width>e[j].height && lis[i][0]<lis[j][1]+1)?
										(lis[j][1]+1):lis[i][0]
							);
				
				//checking for flipped i
				lis[i][1] = Math.max(
								(e[i].height>e[j].height && e[i].width>e[j].width && lis[i][1]<lis[j][0]+1)?
										(lis[j][0]+1):lis[i][1],
								(e[i].height>e[j].width && e[i].width>e[j].height && lis[i][1]<lis[j][1]+1)?
										(lis[j][1]+1):lis[i][1]
							);
				
				max = Math.max(max, lis[i][0]);
				max = Math.max(max, lis[i][1]);
			}
		}
		
		System.out.println(max);
	}
}
