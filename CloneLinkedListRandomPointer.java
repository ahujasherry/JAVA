import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
	
	 //insert additional nodes in between every node and adjust random pointers
    // O(1) space complexity
    public Node copyRandomList1(Node head)
    {
        if(head==null ) return head;
        Node curr = head,temp=null; 
  
        //put additional pointers in org list
        while (curr != null) 
        { 
             temp = new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            if(curr.next!=null) curr=curr.next.next;
            else curr=curr.next;
            
        } 
  
        curr = head; 
		
		//adjsut random pointers
        while (curr != null) 
        { 
          
            if(curr.next!=null)
            {
                if(curr.random!=null)curr.next.random=curr.random.next;
                curr=curr.next.next;
            }
        
        } 
        
     curr = head; 
    Node copy = head.next; 
  
    temp = copy; 
	
	//get original list back
    while (curr!=null && copy!=null) 
    { 
        if( curr.next!=null)
            curr.next =curr.next.next ; 
  
        if( copy.next!=null)
            copy.next = copy.next.next; 
        curr = curr.next; 
        copy = copy.next;
    } 
  
  
      return temp;
        
    }
	
	//O(n) space complexity
    public Node copyRandomList(Node head)
    {
        if(head==null ) return head;
        Node origCurr = head, cloneCurr = null; 
  
        Map<Node, Node> map = new HashMap<Node, Node>(); 
  	
	//make hashmap of original nodes data
        while (origCurr != null) 
        { 
            cloneCurr = new Node(origCurr.val); 
            map.put(origCurr, cloneCurr); 
            origCurr = origCurr.next; 
        } 
  
	
        origCurr = head; 
  
	//adjusting random and next pointers of clone linked list using hashmap
        while (origCurr != null) 
        { 
            cloneCurr = map.get(origCurr); 
            cloneCurr.next = map.get(origCurr.next); 
            cloneCurr.random = map.get(origCurr.random); 
            origCurr = origCurr.next; 
        } 
  
        return map.get(head); 
        
    }
}