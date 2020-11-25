import java.util.ArrayList;
import java.util.HashMap;

/*
Given a String, find out the maximum substring which is repeating

Eg: "banana"
Output: 3 (ana) 

*/
public class MaxRepeatingSubString {
	public static void main(String[] args) {
		String str = "banana";
		
		int low = 1;
		int high = str.length();
		int mid = 0;
		int ans = 1;
		
		while(low<=high) {
			mid = (low+high)/2;
			int p = 5;
			int value = 0;
			System.out.println("low: "+low);
			System.out.println("high: "+high);
			System.out.println("Mid: "+mid);
			System.out.println("---------------");
			
			HashMap<Integer, ArrayList<String>> hs = new HashMap<>();
			
			for(int i=0; i<mid; i++) {
				value += Math.pow(p, i)*(int)str.charAt(i);
			}
			
			ArrayList<String> al = new ArrayList<String>();
			al.add(str.substring(0, mid-1));
			hs.put(value, al);
			int l = 1;
			int h = mid;
			
			boolean flag = false;
			
			while(h<str.length()) {
				ArrayList<String> temp = new ArrayList<String>();
				
				
				
				value = value - (int)str.charAt(l-1);
				value = value/p;
				value = (int) (value + str.charAt(h)*(Math.pow(p, mid-1)));
								
				if(hs.containsKey(value)) {
					
					for(String element: hs.get(value)) {
						if(element.equals(str.substring(l, h+1))){
							flag = true;
							System.out.println("break");
							break;
						}
						else {
							temp = hs.get(value);
							temp.add(str.substring(l, h+1));
							hs.put(value, temp);
						}
					}
				}
				else {
					temp.add(str.substring(l, h+1));
					
					hs.put(value, temp);
				}

				l++;
				h++;
			}
			
			if(flag) {
				low = mid+1;
				ans = (ans>mid)?ans:mid;
			}
			else {
				high = mid-1;
			}
		}
		
		System.out.println("Answer : "+ans);
	}
}
