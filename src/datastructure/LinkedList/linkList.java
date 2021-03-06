package datastructure.LinkedList;

public class linkList{
	public Node head;
	public int count;
	
	public linkList() {
	head = new Node(1);
	count=0;
	}
	
	
	public boolean add(int d) {
		Node end = new Node(d);
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		current.next = end;
		count++;
		return true;
	}
	
	public boolean add(int d,int index){
    	Node end = new Node(d);
    	Node current = head;
    	int jump;
    	

    	if(index>count || index<1){
    		System.out.println("Add Failed: index out of bounds of size of linked list!!");
    		return false;
    	}
    	else{
    		jump = 0;
    		while(jump<index-1){
    			current = current.next;
    			jump++;
    		}
    		end.next = current.next;
    		System.out.println("end.next value:"+end.next);
    		current.next = end;
    		count++;
    		System.out.println("Success! "+d+" added at index "+index);
            return true;
    	}
    }
	
	//can be used to print all the elements present in the linkedList
	public void show() {
		Node current =head;
		while(current.next !=null) {
			current = current.next;	
			System.out.println(current.data);
		}
	
		
	}
	public void showIndex(int index) {
		Node current = head;
		int jump=0;
		while( jump <index ) {
			current = current.next;
			jump++;
		}
		System.out.println("value at index no."+ index + " is "+current.data);
	}
	
	public boolean del(int d) {	
			Node current = head;
			while(current.next != null) {
				if(current.next.data ==  d) {
					current.next = current.next.next;
					count--;
				System.out.println("Deleted successfully");
				return true;
				}
				current =  current.next;
			}	
		return false;
	
	}	   
	
//To delete the specific node from the LinkedList..

	public boolean delIndex(int index) {
	Node current = head;
	int jump;
	if(index>count || count <1) {
		System.out.println("Not valid index value");
		return false;
	}
	else
	{
		jump=0;
		while(jump<index-1) {
			current=current.next;
			jump++;
		}
		current.next =  current.next.next;
		System.out.println("index "+index+" value is deleted successfully");
		return true;
	}
}

// Returns the value of nTh last from the LinkedList... 

public void nthIndexValue(int x) {
	Node temp = head;
	int leng=0;
	while(temp!=null) {
		temp=temp.next;
		leng++;
	}
	if(leng<x){
		System.out.println("Invalid value");
	}
	
	temp=head;
	for(int i=1;i<leng-x+1;i++) {
		temp=temp.next;		
	}
	System.out.println("nth value is: "+temp.data);
}

// it reuturns the nth last node value...
public void nthIndexValueRec(linkedList p,int p2) {
	

}
public void nthIndexValueOptimised(int x) {
		Node temp=head,lastNode=null;
		
		for(int count=1;count<x;count++) {
			if(temp!=null) {
				temp=temp.next;
			}
		}
		while(temp!=null) {
			if(lastNode==null) {
				lastNode=head;
			}
			else
				lastNode=lastNode.next;
			temp=temp.next;
		}

		if(lastNode!=null) {
			System.out.println(x+" Index value from the last:"+lastNode.data);
		}
	}
//Returns the last node value...
	public void lastNodeValue() {
		Node temp = head;
		while(temp!=null) {
			temp=temp.next;
			if(temp.next==null) {
			System.out.println("value of last node in LinkedList is : " + temp.data);
			return;
			}
		}
	}
	
//it checks whether the Linkedlist is null terminated or not...
	//Floyd approach...
	public boolean loopFinder() {
		Node node1=head,node2=head;
		while(node1!=null && node1.next!=null) {
			node1=node1.next.next;
			node2=node2.next;
			if(node1==node2) {
					return true;
			}
			}
		return false;

	}
	
//it checks whether the list has loop or not and if
	//there is a loop it will return the start node of the loop
	public void loopNodeFinder() {
		Node node1=head,node2=head;
		boolean loop=false;
		while(node1!=null && node1.next!=null) {
			node1=node1.next.next;
			node2=node2.next;
			if(node1==node2) {
					loop=true;
					break;
			}
			}
	if(loop) {
		node1=head;
		while(node1!=node2) {
			node1=node1.next;
			node2=node2.next;
		}
		System.out.println("The loop start from"+node1.data);
		return;
	}
	return;
}

	// To reverse the LinkedList
	public void reverseLinkedList() {
		Node current = head;
		Node  prev =null;
		while(current!=null) {
		Node nextNode=current.next;
		current.next = prev;
		prev=current;
		current=nextNode;
		}
		System.out.println("\nLinkedList in reverse Order:\n");
		while(prev!=null) {
		System.out.println(prev.data);
		prev=prev.next;
	}
					
		}
	
	public void middleElement() {
		Node node1=head;
		Node node2=head;
		if(head!=null) {
		while(node1!=null && node1.next!=null) {
			node1=node1.next.next;
			node2=node2.next;
		}
		System.out.println("\nMiddle Element: "+node2.data);
	}
}
	public static void reverseLinkedListRecursive(Node p) {
			if(p==null)
			return;
		reverseLinkedListRecursive(p.next);
		System.out.println(p.data);
	}
	public void evenLength() {
		Node node1=head;
		Node node2=head;
		while(node1!=null && node1.next!=null) {
			node1=node1.next.next;
		}
		if(node1==null) {
			System.out.println("Odd length");
		}
		else
			System.out.println("Even length");
	}
	public static void mergeLinkedList(Node l1,Node l2) {
		Node mergerNode = new Node(0);
		Node tail = mergerNode;
		while(true) {
			if(l1 ==null) {
				tail.next=l2;
				break;
			}
			if(l2==null) {
				tail.next = l1;
				break;
			}
			if(l1.data <= l2.data) {
				tail.next = l1;
				l1=l1.next;
			}else
			{
				tail.next = l2;
				l2=l2.next;
			}
			tail=tail.next;
		}
	while(mergerNode!=null) {
		System.out.println(mergerNode.data);
		mergerNode=mergerNode.next;
		}

	}
public static void pairReverse(Node l) {
	System.out.println("Reversed:");
	Node temp1=null;
	Node temp2=null;
	while(l!=null && l.next!=null) {
		if(temp1!=null) {
			temp1.next.next= l.next;
		}
		temp1=l.next;
		l.next=l.next.next;
		temp1.next=l;
		if(temp2==null) {
			temp2=temp1;
		}
			l=l.next;
	}
	while(temp2.next !=null) {
		temp2 = temp2.next;
		System.out.println(temp2.data);
	}

}
public static boolean palingdrom(Node l) {
    if(l == null || l.next == null)
        return true;
    Node fast = l.next;
    Node slow = l;
    
    // find out mid element of list
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    fast = slow.next;
    slow.next = null;
    
    // Now reverse the fast list
    Node reverse = null;
    Node prev = null;
    while (fast != null) {
        prev = fast;
        fast = fast.next;
        prev.next = reverse;
        reverse = prev;     
    }
    
    //Now compare reverse list and head list
    while(l != null && reverse != null) {
        if(l.data != reverse.data){
            return false;
        }
        l = l.next;
        reverse = reverse.next;
    }
    return true;
}	


public static Node reverseKNodes(Node head, int k) { 
    Node current = head; 
    Node preTail = null;
    Node preCur = head;
  
    
    while(current!=null) {
    	int count = k;
    	Node tail = null;
    	while(current!=null && count >0) {
    		Node next =current.next;
    		current.next= tail;
    		tail=current;
    		current = next;
    		count--;
    	}
    	if(preTail != null) {
    		preTail.next=tail;
    	}else {
    		head = tail;
    	}
    	preTail = preCur;
    	preCur = current;
    }
  return head;
} 
  
			
	public static void main(String[] args) {
	
	    	linkList L = new linkList();
	    	linkList M= new linkList();
	    	L.add(1);
	    	L.add(2);
	    	L.add(2);
	    	L.add(1);
	    	L.add(1);
	    	L.add(2);
	    	L.add(2);
	    	L.add(1);
	    	
	    	//for checking the reverLinkedListRecursive
	    	M.add(1);
	    	M.add(2);
	    	M.add(3);
	     	M.add(4);
//	     	M.show();
	       M.head = reverseKNodes(M.head,3); 
	       M.show();
	      
	     pairReverse(M.head);
	     	L.nthIndexValueOptimised(2);
	    	L.lastNodeValue();
	    	L.middleElement();
	    	System.out.println("Loops valueloopFinder()");
	    	L.loopNodeFinder();
	    	System.out.println("-------Lists Merged---------");
	    	mergeLinkedList(M.head,L.head);
	    	System.out.println("-----------------------------");
	    	    
	    	reverseLinkedListRecursive(M.head);
	    	
	    	L.evenLength();
	    	M.evenLength();
	    	
}

}