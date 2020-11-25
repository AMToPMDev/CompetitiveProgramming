package hackerEarth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Given input of items as below:
Pallet, Container, Bay, Multi-Pallet
Pallet = 50 Container
Bay = 5000 Container
Multi-Pallet = 500 Container

Generate output as:
Bay = 10Multi-Pallet = 100Pallet = 5000Container

largest item should be placed first
*/


public class containerEsko {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		HashMap<String, Integer> hs = new HashMap<>();
		
		String input = s.nextLine();
		String[] str = new String[input.split(",").length];
		
		for(int i=1; i<input.split(",").length; i++) {
			str[i] = s.nextLine();
			
			String[] str_arr = str[i].split(" ");
			int value;
			int multiplier = 1;
			
			if(hs.containsKey(str_arr[0])){
				value = hs.get(str_arr[0]);
				
				multiplier = value;
			}
			else {
				hs.put(str_arr[0], 1);
			}
			
			if(hs.containsKey(str_arr[3])){
				value = hs.get(str_arr[3]);
				
				if(Integer.parseInt(str_arr[2])*multiplier > value) {
					hs.put(str_arr[3], Integer.parseInt(str_arr[2])*multiplier);
				}
			}
			else {
				hs.put(str_arr[3], Integer.parseInt(str_arr[2])*multiplier);
			}
		}
		
		for(int i=1; i<input.split(",").length; i++) {
			String[] str_arr = str[i].split(" ");
			
			int value;
			int multiplier = 1;
			
			value = hs.get(str_arr[3]);
			
			multiplier = value/Integer.parseInt(str_arr[2]);
			
			hs.put(str_arr[0], multiplier*hs.get(str_arr[0]));
		}
		
		for(Map.Entry<String, Integer> element: hs.entrySet()) {
			System.out.println("Key: "+element.getKey()+", Value: "+element.getValue());
		}
	}
}
