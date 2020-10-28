
public class DeleteNthNodeFromEnd
{ 
	Node head; 
	class Node 
	{ 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
	Node deleteNode(int key) 
    { 
    Node start = new Node(0);
    Node slow = start, fast = start;
    slow.next = head;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=key+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
        

    } 
  
    // Function to insert a new Node at front of the list 
    public void push(int new_data) 
    { 
        Node new_node = new Node(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 
  
    // Function to print the linked list 
    public void printList() 
    { 
        Node tnode = head; 
        while (tnode != null) { 
            System.out.print(tnode.data + " "); 
            tnode = tnode.next; 
        } 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
    	DeleteNthNodeFromEnd llist = new DeleteNthNodeFromEnd(); 
  
        llist.push(5); 
        llist.push(4); 

        llist.push(3); 
        llist.push(2); 
        llist.push(1);
  
        System.out.println("\nCreated Linked list is:"); 
        llist.printList(); 
  
        int N = 2; 
        llist.head=llist.deleteNode(N); 
  
        System.out.println("\nLinked List after Deletion is:"); 
        llist.printList(); 
    } 
} 

