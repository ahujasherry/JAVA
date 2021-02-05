
/*
	using O(1) time and O(n) space : use two stacks, second one will keep only min whenever we add/delete
	below is O(1) time and O(1) space using linked list kind
	
*/
class Node
{
    int val,min;
    Node next;
    public Node(int val,int min,Node next)
    {
        this.val=val;
        this.min=min;
        this.next=next;
    }
}
class MinStack {

    Node head;    
    public MinStack() 
    {
        
        
    }
    
    public void push(int x) 
    {
        if(head==null)
        {
            head=new Node(x,x,null);
        }
        else
        {
            head=new Node(x,Math.min(x,head.min),head);
        }
        
    }
    
    public void pop() 
    {
        head=head.next;
        
    }
    
    public int top() 
    {
        return head.val;
        
    }
    
    public int getMin() 
    {
        return head.min;
        
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */