//Iterative method
import java.util.*;

public class ReverseLinkedList{
    public ListNode reverseList(ListNode head) 
    {
        if(head==null) return null;
        if( head.next == null ) return head;
        ListNode prev = null,current = head, next = null;
        while (current != null) 
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
        
    }
}