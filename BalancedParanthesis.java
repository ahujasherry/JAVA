class Solution {
    public boolean isValid(String expr) 
    {
         Deque<Character> stack = new ArrayDeque<Character>(); 
        
        for (int i = 0; i < expr.length(); i++)  
        { 
            char x = expr.charAt(i); 
  
            if (x == '(' || x == '[' || x == '{')  
            { 
                // Push the element in the stack 
                stack.push(x); 
                continue; 
            } 
  
            // IF current current character is not opening 
            // bracket, then it must be closing. So stack 
            // cannot be empty at this point. 
            if (stack.isEmpty()) 
                return false; 
            
            char check; 
            
            switch (x) 
            { 
                case ')': 
                    check = stack.pop(); 
                    if (check == '{' || check == '[') 
                        return false; 
                    break; 

                case '}': 
                    check = stack.pop(); 
                    if (check == '(' || check == '[') 
                        return false; 
                    break; 

                case ']': 
                    check = stack.pop(); 
                    if (check == '(' || check == '{') 
                        return false; 
                    break; 
                } 
        } 
  
        // Check Empty Stack 
        return (stack.isEmpty()); 
    } 
        
    }
