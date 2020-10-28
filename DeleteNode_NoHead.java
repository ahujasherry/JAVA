/*
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.
*/

import java.util.*;
public class Solution {
    public void deleteNode(ListNode current) 
    {
        if(current==null) return ;
        if(current.next==null) return ;
    
        //swap current and future data
        current.val=current.next.val;
    
        current.next=current.next.next;
        return ;
        
    }
}