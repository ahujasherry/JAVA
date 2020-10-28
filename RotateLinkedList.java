
import java.util.*;
class RotateLinkedList 
{
    Node head; 
 
   
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
   
    void rotateList(int k)
    {
        //empty list
    	if (k == 0)
            return;
 
    	Node current = head;
 
        //reach to required node and boundary check
    	int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
 
        // If current -> NULL, k >= count of nodes in linked list
        if (current == null)
            return;
 
        Node kthNode = current;
 
        while (current.next != null)
            current = current.next;
 
        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
  
    }
 
    void push(int new_data)
    {
       
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
 
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
 
    public static void main(String args[])
    {
    	RotateLinkedList llist = new RotateLinkedList();
 
       for (int i = 100; i >= 50; i -= 10)
            llist.push(i);
 
        System.out.println("input list");
        llist.printList();
 
        llist.rotateList(3);
 
        System.out.println("Rotated Linked List");
        llist.printList();
    }
} 

