
/* 
	find first node of loop in linked list in O(n) time complexity and constant memory space
*/
import java.util.*;

public class FirstNodeOfLoop
{

static Node FirstNode(Node head)
{
 
    // temporary node
    Node temp = new Node();
    while (head != null) 
    {
 
        //no loop
        if (head.next == null) 
        {
            return null;
        }
 
	//first loop node        
	if (head.next == temp)
        {
            break;
        }
 
        //go to next of current
	Node nex = head.next;
 
        // Make next point to temp
        head.next = temp;
 
        // Get to the next node in the list
        head = nex;
    }
 
    return head;
}

}