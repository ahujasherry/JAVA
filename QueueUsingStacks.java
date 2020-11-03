//implement queue basic opeartions using stacks

class MyQueue 
{

    Stack<Integer> s1; 
    Stack<Integer> s2; 
       
    
    public MyQueue()
    {
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
       
    }
    
    public void push(int x) 
    {
        s1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() 
    {
        int x; 
  
        if (s1.isEmpty() && s2.isEmpty()) { 
            return -1;
        } 
  
        /* Move elements from stack1 to stack 2 only if 
        stack2 is empty */
        if (s2.isEmpty()) 
        { 
            while (!s1.isEmpty()) 
            { 
                x = s1.peek(); 
                s2.push(x); 
                s1.pop();
            } 
        } 
        x = s2.peek();
        int ans=x;
        s2.pop();
        
        //restore stack
        if (s1.isEmpty()) 
        { 
            while (!s2.isEmpty()) 
            { 
                x = s2.peek(); 
                s1.push(x); 
                s2.pop();
            } 
        } 
        
        
        return ans; 
        
    }
    
    /** Get the front element. */
    public int peek() 
    {
        int x; 
  
        if (s1.isEmpty() && s2.isEmpty()) { 
            return -1;
        } 
  
        /* Move elements from stack1 to stack 2 only if 
        stack2 is empty */
        if (s2.isEmpty()) 
        { 
            while (!s1.isEmpty()) 
            { 
                x = s1.peek(); 
                s2.push(x); 
                s1.pop();
            } 
        } 
        x = s2.peek();
        int ans=x;
        //restore stack
        
        if (s1.isEmpty()) 
        { 
            while (!s2.isEmpty()) 
            { 
                x = s2.peek(); 
                s1.push(x); 
                s2.pop();
            } 
        } 
        return ans; 
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() 
    {
        if (s1.isEmpty() && s2.isEmpty()) 
        { 
            return true;
        } 
        else
            return false;
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */