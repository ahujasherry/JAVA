//implement stack basic operations using 2 queues

import java.util.*;
public class StackUsingQueues{
    
    Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>(); 
    int curr_size; 
    
    /** Initialize your data structure here. */
    public MyStack() 
    {
         curr_size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) 
    {
        q1.add(x);
        curr_size++;
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
        if (q1.isEmpty()) 
            return -1; 
  
        // Leave one element in q1 and 
        // push others in q2. 
        while (q1.size() != 1) 
        { 
            q2.add(q1.peek()); 
            q1.remove(); 
        } 
  
        // Pop the only left element 
        // from q1 
        int temp=q1.peek();
        q1.remove();
        curr_size--; 
  
        // swap the names of two queues 
        Queue<Integer> q = q1; 
        q1 = q2; 
        q2 = q; 
        return temp;
        
    }
    
    /** Get the top element. */
    public int top() 
    {
         if (q1.isEmpty()) 
            return -1; 
  
        while (q1.size() != 1) 
        { 
            q2.add(q1.peek()); 
            q1.remove(); 
        } 
  
        int temp=q1.peek(); 
        q1.remove(); 
        q2.add(temp); 
  
        Queue<Integer> q = q1; 
        q1 = q2; 
        q2 = q; 
        return temp;
        
    }
    
    public boolean empty() 
    {
        return q1.isEmpty() ? true:false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */