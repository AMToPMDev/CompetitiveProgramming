import java.util.Arrays;
import java.util.Comparator;

/*
Given height, width and length of n boxes. Find the maximum height when boxes are stacked on one another.
To stack one box on other, the surface are of top box should be lesser than its lower one. 
Consider that we have infinite supply on each box. 
Flipping of boxes is allowed.

Eg:

Length  : 2 2 3
Breadth : 5 7 4
Height  : 6 4 8

Ans: 11

*/

class Box {
	int length;
	int breadth;
	int height;
	
	public Box(int l, int b, int h) {
		length = l;
		breadth = b;
		height = h;
	}
}

class sortBoxes implements Comparator<Box> {

	@Override
	public int compare(Box o1, Box o2) {
		if(o1.length*o1.breadth > o2.length*o2.breadth) return 1;
		else return -1;
	}
	
}
public class stackTheBoxes {
	public static void main(String[] args) {
		int[] length = {2,2,3};
		int[] breadth = {5,7,4};
		int[] height = {6,4,8};
		
		int len = length.length;
		
		Box[] box = new Box[3*len];
		
		//We can make 6 instances on each box and use cover Envelope logic
		//Or we can optimize it to 3 instance with condition that length will be greater than breadth always
		//That way flipping length & breadth will not get us max answer to 3 instances will work
		for(int i=0; i<len; i++) {
			box[i*3] = new Box(Math.max(length[i], breadth[i]), Math.min(length[i], breadth[i]), height[i]);
			box[i*3+1] = new Box(Math.max(length[i], height[i]), Math.min(length[i], height[i]), breadth[i]);
			box[i*3+2] = new Box(Math.max(breadth[i], height[i]), Math.min(breadth[i], height[i]), length[i]);
		}
		
		Arrays.sort(box, new sortBoxes());
		
		for(int i=0; i<box.length; i++) {
			System.out.println("length: "+box[i].length+", breadth: "+box[i].breadth+", height: "+box[i].height);
		}
		
		int[] stackHeight = new int[box.length];
		//initial stack height would be equal to box height
		for(int i=0; i<stackHeight.length; i++) stackHeight[i] = box[i].height;

		int max = Integer.MIN_VALUE;
		
		//Implementation is similar to coverMaxEnvelope problem
		for(int i=1; i<box.length; i++) {
			for(int j=0; j<i; j++) {
				if(box[i].length>box[j].length && box[i].breadth>box[j].breadth &&
						stackHeight[i]<box[i].height+stackHeight[j]) {
					
					stackHeight[i] = box[i].height + stackHeight[j];
					max = Math.max(max, stackHeight[i]);
				}
			}
		}
		
		System.out.println(max);
	}
}
