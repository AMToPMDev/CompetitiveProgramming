import java.util.Arrays;
import java.util.Comparator;

/*
Given n envelopes with height and width in an array.
Find the maximum number of envelopes you can stack one inside another.
Envelope can only be stacked if height and width are strictly smaller.

Eg:

height : 5 6 6 2 
width  : 4 4 7 3

Ans: 3

2 < 5 < 6
3 < 4 < 7

*/

class Envelope {
	int height;
	int width;
	
	public Envelope(int h, int w) {
		height = h;
		width = w;
	}
}

// To sort envelopes by area 
class sortEnvelopes implements Comparator<Envelope> {

	@Override
	public int compare(Envelope e1, Envelope e2) {
		if(e1.height*e1.width > e2.height*e2.width) return 1;
		else return -1;
	}
	
}

public class coverMaximumEnvelopes {

	public static void main(String[] args) {
		int[] height = {5,4,6,2};
		int[] width = {4,4,7,3};
		int max = Integer.MIN_VALUE;
		int len = height.length;
		
		//creating and sorting envelopes based on area
		//Note : On sorting envelopes by width/height will also get same answer
		Envelope[] e = new Envelope[len];
		for(int i=0; i<len; i++) {
			e[i] = new Envelope(height[i], width[i]);
		}
		
		Arrays.sort(e, new sortEnvelopes());
		
		int[] lis = new int[len];
		for(int i=0; i<len; i++) lis[i] = 1;
		
		
		for(int i=1; i<len; i++) {
			for(int j=0; j<i; j++) {
				if(e[i].height>e[j].height && e[i].width>e[j].width && lis[i]<lis[j]+1) {
					lis[i] = lis[j] + 1;
					max = Math.max(max, lis[i]);
				}
			}
		}
		
		System.out.println(max);
	}
}
