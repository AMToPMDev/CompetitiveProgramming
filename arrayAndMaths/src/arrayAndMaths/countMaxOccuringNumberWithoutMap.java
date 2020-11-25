package arrayAndMaths;

/*

Find the number which occurs more than n/2 times in an array.

Input : [3,3,4,4,4,2,2,4,4]
n:9
Output : 4 (as it occurs for 5 times)

PS: If no number's count>n/2, then return 0.

Hashmap cannot be used.

Idea is to cancel out numbers until last number and check the count at the end
*/

public class countMaxOccuringNumberWithoutMap {
	public static void main(String args[]) {
		int input[] = {2,3,3,3,3,2,2,2,2};
		int n = input.length;
		
		int pm = input[0];   //pm means potential maximum count value
		int count = 1; //count is used to count elements if they are repeating
		
		for(int i=1;i<n;i++) {
			if(input[i] == pm) {
				count++;
			}
			else if(input[i] != pm) {
				count--;
				if(count==-1) {
					pm = input[i];
					count=1;
				}
			}
		}
		
		int countOfMax = 0;
		if(count>0) {
			for(int i=0; i<n; i++) {
				if(input[i] == pm) {
					countOfMax++;
				}
			}
		}
		
		if(countOfMax > Math.floor(n/2)) {
			System.out.println(pm);
		}
		else {
			System.out.println("No Maximum count found");
		}
	}
}
