package arrayAndMaths;

public class gcdOfNumberRecursion {
	
	public static int gcd(int a, int b) {
		if(a==0)
			return b;
		else
			return gcd(b%a, a);
	}
	
	public static void main(String args[]) {
		int a = 4;
		int b = 6;
		
		System.out.println(gcd(a,b));
	}
}
