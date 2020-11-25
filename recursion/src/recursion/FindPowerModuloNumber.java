package recursion;

/*

Given 0 <= x,y,m <= 10^9

Find (x^y)%m
*/
public class FindPowerModuloNumber {

	public static int modulo(int x, int y, int m) {
		
		if(y==0) {
			return 1;
		}
		
		if(y%2==0) {
			return modulo((x*x),y/2,m)%m;
		}
		else {
			return (x*modulo((x*x),y/2,m))%m;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(100000%85);
		System.out.println(modulo(10,5,85));
	}

}
