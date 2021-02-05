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
class Solution {
    
    /*
    //with stack solution
    public void flatten(TreeNode root) 
    {
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(root);
        
        while(!s.isEmpty())
        {
            TreeNode top=s.pop();
            if(top==null ) return;
            
            if(top.right!=null) s.push(top.right);
            if(top.left!=null) s.push(top.left);
            
            if(!s.isEmpty())
            {
                top.right=s.peek();
            }
            top.left=null;
        }
        
    }
    */
    
     public void flatten(TreeNode root) 
    {
         if(root==null) return;
         
         //return to node which dosnt have grandchildren
         if(root.left==null && root.right==null) return;
         
         
         if(root.left!=null)
         {
             flatten(root.left);
                
                //store right side in temp
                TreeNode temp=root.right;
                
                //swap
                 root.right=root.left;
                 root.left=null;
                
                //traverse to bottom of right
                 TreeNode parse=root.right;
                 while(parse.right!=null) 
                 {
                     parse=parse.right;
                 }
             
                
                 parse.right=temp;
         }
         if(root.right!=null) flatten(root.right);
         
         
         
         
         
         
         
         
         
         
         
     }
    
}