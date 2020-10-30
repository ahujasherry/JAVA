import java.util.*;
  
 /*
  * 
  * Reverse singly linked list in given size k. If k > n , keep the list as it
  */
public class ReverseLinkedListSizeK 
{
	ListNode head;
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
		public void push(int new_data) 
	    { 
			ListNode new_node = new ListNode(new_data); 
	        new_node.next = head; 
	        head = new_node; 
	    } 
	  
		void printList() 
	    { 
			ListNode temp = head; 
	        while (temp != null) 
	        { 
	           System.out.print(temp.val+" "); 
	           temp = temp.next; 
	        }   
	        System.out.println(); 
	    } 
		
	 public ListNode reverseKGroup(ListNode head, int k) 
	    {
		 	
		 	// t1-> fwd pointer , t2-> tail pointer
	        if(head==null || head.next==null || k==1) return head;
		        ListNode prev = null,t1=head,t2=null,current = head, future = null,newhead=null;
	        
	         ListNode tem=head;
		        int n=0;
		        //calculate the size of list
		        while(tem!=null)
		        {
		        	n++;
		        	tem=tem.next;
		        }
	        
	        while (n>=k) 
	        {
	            
	            //reverse logic
	            for(int i=1;i<=k;i++)
	            {
	                future = current.next;
	                current.next = prev;
	                prev = current;
	                current = future;
	            }
	            
	            //define newhead of final list
	            if(newhead==null) newhead=prev;
	            
	            //point previous tail pointer to current reversed segment
	            if(t2!=null) 	t2.next=prev;
		            
	            //reverse fwd pointer of current segment to next one
	            if(t1!=null)t1.next=current;
	            
	            //update both t1 and t2 when jumping to next segment
	            t2= t1;
	            t1=current;
	            
	            //subtract from size
	            n-=k;
	            prev=null;
	            
	        }
	        
	        return newhead;
	        
	    }
	
	public static void main(String[] args) 
	{
		ReverseLinkedListSizeK llist = new ReverseLinkedListSizeK(); 
        
        
		 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
          
        System.out.println("Given Linked List"); 
        llist.printList(); 
          
        llist.head = llist.reverseKGroup(llist.head, 3); 
  
        System.out.println("Reversed list"); 
        llist.printList(); 
		

	}

}

