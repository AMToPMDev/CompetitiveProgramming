package hackerEarth;

import java.io.*;
import java.util.*; 

public class SmallestLexographicalString {
    BufferedReader in; 
    StringTokenizer st; 
    
    static String swap(String str, int i, int j) 
    { 
        char ch[] = str.toCharArray(); 
        char temp = ch[i]; 
        ch[i] = ch[j]; 
        ch[j] = temp; 
        return new String(ch); 
    } 
    
    public static String minimumString(int n, int k, String s, String t, int[] li, int[] ri) {
        int len = s.length();
        
        TreeMap<Integer, HashSet<Integer>> pairs = new TreeMap<Integer, HashSet<Integer>>();
        HashSet<Integer> buffer = new HashSet<Integer>();
        HashSet<Integer> temp = new HashSet<Integer>();
       
        for(int i=0; i<k; i++) {
        	//adding elements in left index
        	if(!pairs.containsKey(li[i])) {
        		buffer.add(ri[i]);
        		
        		//adding linked elements of right index
        		if(pairs.containsKey(ri[i])) {
        			for(Integer item : pairs.get(ri[i])) {
        				buffer.add(item);
        				
        				if(pairs.containsKey(item)) {
        					temp = pairs.get(item);
        					temp.add(li[i]);
        					pairs.put(item, temp);
        				}
        			}
        		}
        		pairs.put(li[i], buffer);
        		buffer = new HashSet<Integer>();
        	}
        	else {
        		buffer = pairs.get(li[i]);
        		
        		buffer.add(ri[i]);
        		
        		//adding linked elements of right index
        		if(pairs.containsKey(ri[i])) {
        			for(Integer item : pairs.get(ri[i])) {
        				buffer.add(item);
        				
        				if(pairs.containsKey(item)) {
        					temp = pairs.get(item);
        					temp.add(li[i]);
        					pairs.put(item, temp);
        				}
        			}
        		}
        		pairs.put(li[i], buffer);
        		buffer = new HashSet<Integer>();
        	}
        	
        	
        	//adding elements in right index
        	if(!pairs.containsKey(ri[i])) {
        		buffer.add(li[i]);
        		
        		//adding linked elements of right index
        		if(pairs.containsKey(li[i])) {
        			for(Integer item : pairs.get(li[i])) {
        				buffer.add(item);
        				
        				if(pairs.containsKey(item)) {
        					temp = pairs.get(item);
        					temp.add(ri[i]);
        					pairs.put(item, temp);
        				}
        			}
        		}
        		pairs.put(ri[i], buffer);
        		buffer = new HashSet<Integer>();
        	}
        	else {
        		buffer = pairs.get(ri[i]);
        		
        		buffer.add(li[i]);
        		
        		//adding linked elements of right index
        		if(pairs.containsKey(li[i])) {
        			for(Integer item : pairs.get(li[i])) {
        				buffer.add(item);
        				
        				if(pairs.containsKey(item)) {
        					temp = pairs.get(item);
        					temp.add(ri[i]);
        					pairs.put(item, temp);
        				}
        			}
        		}
        		pairs.put(li[i], buffer);
        		buffer = new HashSet<Integer>();
        	}
        }
        
        int[] used = new int[len];
        
        for(int i=0; i<len; i++) {
        	HashSet<Integer> hs = new HashSet<Integer>();
        	int value = 0;
        	int max = 0;
        	boolean flag = false;
    		
        	value = i;
        	max = value;
        	
        	if(pairs.containsKey(i)) {
        		hs = pairs.get(i);
        		
        		for(Integer item: hs) {
        			if(item!=i && used[item]==0 && (t.charAt(i)>t.charAt(item)) && (t.charAt(item)<s.charAt(i))) {
        				value = item;
        				flag = true;
        			}
        			if(s.charAt(item)>s.charAt(max))
        				max = item;
        		}
        		
        		t = swap(t, i, value);
        	}
        	
        	char[] new_s = s.toCharArray();
    		
    		if(new_s[i] > t.charAt(i))
    			new_s[i]=t.charAt(i);
    		
    		s = String.valueOf(new_s);
    		
    		if(!flag) {
    			if(t.charAt(i) <t.charAt(max)) {
    				t = swap(t, i, max);
    			}
    		}
    		
    		used[i] = 1;
        	
//    		System.out.println("i : "+i);
//			System.out.println("s : "+s);
//			System.out.println("t : "+t); 
//			System.out.println("===================");
        }
        
		/*
		 * for(Map.Entry<Integer, HashSet<Integer>> entry: pairs.entrySet()) {
		 * System.out.println("Key = " + entry.getKey() + ", Value = " +
		 * entry.getValue()); }
		 */
        
        return s;
    }
    public void run() throws IOException {
        in=new BufferedReader(new InputStreamReader(System.in));
        int testcase = ni(); 
        while(testcase-- > 0) {
            int n = ni(); 
            int k = ni(); 
            String s = ns(); 
            String t = ns(); 
            int[] li = new int[k];
            int[] ri = new int[k];
            for(int i = 0; i < k; i++) {
                li[i] = ni(); 
                ri[i] = ni(); 
            }
            String ans = minimumString(n, k, s, t, li, ri); 
            System.out.println(ans); 
        }
    }
    public static void main(String[] args) throws IOException {
        new SmallestLexographicalString().run() ;
    }
    String ns() throws IOException {
        return nextToken();
    }
    long nl() throws IOException {
        return Long.parseLong(nextToken());
    }
    int ni() throws IOException {
        return Integer.parseInt(nextToken());
    }
    double nd() throws IOException {
        return Double.parseDouble(nextToken());
    } 
    String nextToken() throws IOException {
        if(st==null || !st.hasMoreTokens())
            st=new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}