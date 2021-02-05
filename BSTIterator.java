/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root) 
    {
        s=new Stack<TreeNode>();
        TreeNode curr=root;
        while(curr!=null)
        {
            s.push(curr);
            if(curr.left!=null)
                curr=curr.left;
            else break;
        }
    }
    
    public int next() 
    {
        TreeNode top=s.pop();
        int tmp=top.val;
        if(top.right!=null)
        {
            top=top.right;
            while(top!=null)
            {
                 s.push(top);
                 if(top.left!=null)
                    top=top.left;
                else break;
            }
        }
          
        return tmp;        
        
    }
    
    public boolean hasNext() 
    {
        return !s.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */