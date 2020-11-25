import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/*
Given an array, find the number of quadruples whose sum is k.

Eg: 
arr: [2,2,4,0,2,-2] , k=4

quadruples with sum as 4:
[4,0,2,-2]
[2,2,-2,2]
.
.
and so on...
(find total count of such quadruples
*/

class Pair {
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	private int a,b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public boolean contains(int value) {
		if(a==value || b==value)
			return true;
		else 
			return false;
	}
}
public class QuadruplesWithSumAsK {

	public static void main(String[] args) {
		int[] arr = {2,2,4,0,2,-2};
		int k = 4;
		
		HashMap<Integer, Vector<Pair>> hs = new HashMap<Integer, Vector<Pair>>();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				Pair p = new Pair(i,j);
				
				if(hs.containsKey(arr[i] + arr[j])) {
					Vector<Pair> v = hs.get(arr[i] + arr[j]);
					v.add(p);
					hs.put((arr[i]+arr[j]), v);
				}
				else {
					Vector<Pair> v = new Vector<Pair>();
					v.add(p);
					hs.put((arr[i]+arr[j]), v);
				}
			}
		}
		int result = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				int key = arr[i]+arr[j];
				if(hs.containsKey(k - key)) {
					Vector v = hs.get(k - key);
					Iterator value = v.iterator(); 
					
					while(value.hasNext()) {
						Pair p = (Pair)value.next();
						if(!p.contains(i) && !p.contains(j)) {
							result++;
							System.out.println(arr[p.getA()] + " , " + arr[p.getB()] + " , " + arr[i] + " , " + arr[j] + " , ");
						}
					}
				}
			}
		}
		
		System.out.println("Result : "+result);
	}
}
