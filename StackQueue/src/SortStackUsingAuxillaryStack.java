import java.util.Stack;

/*
Sort given stack using an auxiliary (extra) stack.  
*/
public class SortStackUsingAuxillaryStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(-1);
		st.push(4);
		st.push(5);
		int count = st.size();
		
		Stack<Integer> temp = new Stack<Integer>();
		int min, c;
		
		while(count > 0) {
			c=0;
			if(temp.size()!=0){
				min = st.pop();
				
				while((temp.size()>0) && (temp.peek() > min)) {
					c++;
					st.push(temp.pop());
				}
				temp.push(min);
				while(c>0) {
					c--;
					temp.push(st.pop());
				}
			}
			else {
				min = st.pop();
				temp.push(min);
			}
			
			count--;
		}
		
		count = temp.size();
		
		while(count > 0) {
			st.push(temp.pop());
			count--;
		}
		
		for(Object element: st.toArray()) {
			System.out.print(element + ",");
		}
		
	}
}
