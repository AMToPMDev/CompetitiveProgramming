/*
There is a string containing values a & b as below:
abaaba

We have been given a value k. We can toggle characters from a->b/b->a k number of times.
We have to maximize length of subarray with same characters

Eg:
Input : abaaba
k = 1

Output : aaaaba / abaaaa (length: 4)
 
*/
public class MaxSubArrayWithToggleWithPointers {
	public static void main(String[] args) {
		String str = "abaaba";
		int k = 1;
		int i=0, j=0, count=0, ans=0, k_temp=0;
		
		//We will first find maximum subarray with a's
		i = 0;
		j = 0;
		count = 1;
		ans = 0;
		
		int temp = 0;
		while(j<str.length()) {
			if(str.charAt(j) == 'a') {
				temp++;
			}
			else {
				temp++;
				k_temp++;
			}
			
			if(k_temp>k) {
				while(k_temp>k && i<str.length()) {
					
					if(str.charAt(i)=='b') {
						k_temp--;
					}
					i++;
					temp--;
				}
				if(i>j)j=i;  //When k=0, this condition is needed or when i>j this condition is needed.
			}
			System.out.println("i : "+i);
			System.out.println("j : "+j);
			System.out.println("temp : "+temp);
			System.out.println("k_temp : "+k_temp);
			System.out.println("--------------");
			ans = (ans>temp)?ans:temp;
			j++;
		}
		
		
		
		//We will first find maximum subarray with b's
		i = 0;
		j = 0;
		count = 1;
		k_temp=0;
		temp = 0;
		while(j<str.length()) {
			if(str.charAt(j) == 'b') {
				temp++;
			}
			else {
				temp++;
				k_temp++;
			}
			
			if(k_temp>k) {
				while(k_temp>k && i<str.length()) {
					if(i<str.length() && str.charAt(i)=='a') {
						k_temp--;
					}
					i++;
					temp--;
				}
				if(i>j)j=i;  //When k=0, this condition is needed or when i>j this condition is needed.
			}
			ans = (ans>temp)?ans:temp;
			j++;
		}
		
		
		System.out.println("Max subarray length : "+ans);
	}

}
