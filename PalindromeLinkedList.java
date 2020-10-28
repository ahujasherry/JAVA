import java.util.*;
class PalindromeLinkedList{
    ListNode ref;
    
    public  boolean isPal(ListNode node)
    {
        if(node==null) return true;
        
        boolean ans=isPal(node.next);
        boolean isEqual= (ref.val==node.val)? true:false;
        ref=ref.next;
        return isEqual && ans;
        
    }
    public boolean isPalindrome(ListNode head) 
    {
        ref=head;
        
        boolean ans=isPal(head);
        return ans;
        
    }
}