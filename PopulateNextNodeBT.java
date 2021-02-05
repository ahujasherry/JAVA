/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
   
    
     /*uses extra space of queue, we can also use prev Node pointer instead of adding null
    public Node connect(Node root) 
    {
        Node temp=root;
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>(); 
       
        //add null into queue whenever level ends
        q.offer(root);
        q.offer(null);
        
        while (!q.isEmpty())
        {
            Node front=q.poll();
            if(front!=null)
            {
                front.next=q.peek();
                if (front.left != null) 
                    q.add(front.left);  
                if (front.right != null) 
                    q.add(front.right);
            }
            else if(front==null && !q.isEmpty())  //if front is null, that means end of                     current level, so add one null for nexr level end
            {
                
                q.offer(null);
            }
            
            
        }
        
        return temp;
    }*/
    
    //Constant extra space
    
    public Node connect(Node root) 
    {
       
        if(root==null) return null;
        connectHelper(root,null);
        return root;
     }
    
    public static void connectHelper(Node node1, Node node2)
    {
        if(node1==null) return ;
        
        node1.next=node2;
        connectHelper(node1.left,node1.right);
        connectHelper(node1.right,(node1.next!=null)?node1.next.left:null);
    }
    
} 
