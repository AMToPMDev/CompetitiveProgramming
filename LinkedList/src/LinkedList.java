/*
Questions covered:
1. Print a Linked List by traversing it. Also write function to insert an element in Linked List.

2. Reverse a given linked list without using any extra memory.

3. Given a LinkedList, check whether cycle exists in list or not. Also write a function to form a cycle.

4. There are 2 linked list which merge at a given point. Find the point of merger, 
		for eg:
		1 -> 2 -> 3 -> 4 -> 5 -> 6 
   					   /\
   					   | 	
   				 10 -> 11
   Answer: 4
   
5. Merge 2 sorted lists to one list (sorted). 
*/ 

public class LinkedList {
	Node head;
	
	//Node Element
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
		}
	}
	
	
	//Inserting Element
	public static LinkedList insert(LinkedList list, int data) {
		Node new_node = new Node(data);
		
		if(list.head == null) {
			list.head = new_node;
		}
		else {
			Node temp = list.head;
			
			while(temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = new_node;
		}
		
		return list;
	}

	
	//Printing Linked List
	public static void printList(LinkedList list) {
		Node current_node = list.head;
		
		while(current_node != null) {
			System.out.print(current_node.data + ", ");
			current_node = current_node.next;
		}
		System.out.println();
	}
	
//-----Reversing Linked List-------------------------------------------------------------------------
	
	//Reversing LinkedList
	public static LinkedList reverseList(LinkedList list) {
		Node prev = null;
		Node curr = list.head;
		Node next;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = next;
		}
		
		list.head = prev;
		
		return list;
	}
	
//-----Forming and Checking cycle in Linked List------------------------------------------------------
	
	//forming cycle in Linked List
	public static LinkedList formCycle(LinkedList list) {
		Node curr = list.head;
		
		Node cycleStartPoint = curr.next;
		
		while(curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = cycleStartPoint;
		
		return list;
	}
	
	
	//checking if cycle exists in linked list
	public static boolean isCycle(LinkedList list) {
		Node s = list.head;
		Node f = list.head;
		
		boolean flag = false;
		
		while(f != null) {
			s = s.next;
			f = f.next.next;
			
			if(s == f) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	
//-----Checking Y shaped Linked List/Merge point of 2 Linked List------------------------------------------
	//Check length of LinkedList
	public static int length(LinkedList list) {
		Node curr = list.head;
		int c = 0;
		
		while(curr != null) {
			c++;
			curr = curr.next;
		}
		
		return c;
		
	}
	
	//Y Shaped LinkedList
	public static LinkedList makeY(LinkedList list, Node end) {
		Node head = list.head;
		
		while(head.next != null) {
			head = head.next;
		}
		
		head.next = end;
		
		return list;
	}
	
	public static int isYShaped(LinkedList list1, LinkedList list2) {
		int count1 = length(list1);
		int count2 = length(list2);
		
		int diff = (count1>count2)?(count1 - count2):(count2 - count1);
		
		Node head1 = list1.head;
		Node head2 = list2.head;
		
		if(count1>count2) {
			for(int i=0; i<diff; i++) {
				head1 = head1.next;
			}
		}
		else {
			for(int i=0; i<diff; i++) {
				head2 = head2.next;
			}
		}
		
		while(head1 != null && head2 != null) {
			if(head1 == head2) {
				return head1.data;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		
		
		return -1;
	}
	
//----Merging sorted lists----------------------------------------------------------------
	
	public static LinkedList merge(LinkedList list1, LinkedList list2) {
		Node head1 = list1.head;
		Node head2 = list2.head;
		
		LinkedList newList = new LinkedList();
		
		while(head1!=null && head2!=null) {
			if(head1.data < head2.data) {
				newList = insert(newList, head1.data);
				head1 = head1.next;
			}
			else {
				newList = insert(newList, head2.data);
				head2 = head2.next;
			}
		}
		
		while(head1!=null) {
			newList = insert(newList, head1.data);
			head1 = head1.next;
		}
		
		while(head2!=null) {
			newList = insert(newList, head2.data);
			head2 = head2.next;
		}
		
		return newList;
	}
	
	//Main Method
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		
		printList(list);
		
		list = reverseList(list);
		printList(list);
		
		System.out.println("Cycle Exists? : "+isCycle(list));
		
		LinkedList cycledList = list;
		cycledList = formCycle(cycledList);
		System.out.println("Cycle Exists? : "+isCycle(cycledList));
		
		
		LinkedList list1 = new LinkedList();
		
		list1 = insert(list1, 1);
		list1 = insert(list1, 2);
		list1 = insert(list1, 3);
		list1 = insert(list1, 4);
		
		LinkedList list2 = new LinkedList();
		list2 = insert(list2, 11);
		list2 = insert(list2, 12);
		
		Node head = list1.head;
		
		head = head.next;
		
		list2 = makeY(list2, head);
		printList(list1);
		printList(list2);
		
		System.out.println("Point of merger between 2 lists: "+isYShaped(list1, list2));
		
		list1.head = null;
		list2.head = null;
		
		list1 = insert(list1, 1);
		list1 = insert(list1, 3);
		list1 = insert(list1, 5);
		
		list2 = insert(list2, 2);
		list2 = insert(list2, 4);
		list2 = insert(list2, 6);
		list2 = insert(list2, 7);
		list2 = insert(list2, 8);
		
		System.out.println("Merged List: ");
		printList(merge(list1, list2));
	}

}
