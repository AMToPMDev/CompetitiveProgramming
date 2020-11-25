import java.util.HashMap;

/*
In a forest, each rabbit has some colour. Some subset of rabbits(possibly
all of them) tell you how many rabbits have the same colour as them. Those 
answers are placed in an array.

Return the minimum number of rabbits that could be in the forest.
 
*/
public class MinimunRabbitsInJungle {

	public static void main(String[] args) {
		int[] arr = {2,2,2,1,2,5,1,3};
		
		HashMap<Integer, Integer> hs = new HashMap();
		int result = 0;
		int temp;
		
		for(int i=0; i<arr.length; i++) {
			if(hs.containsKey(arr[i])) {
				temp = hs.get(arr[i]);
				
				if(temp+1 == arr[i]) {
					hs.remove(arr[i]);
				}
				else {
					hs.put(arr[i], temp+1);
				}
			}
			else {
				result += arr[i]+1;
				hs.put(arr[i], 0);
			}
		}
		System.out.println(result);
	}

}
