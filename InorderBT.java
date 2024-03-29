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

//Iterative solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode curr) 
    {
        //Result list and stack
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode root=curr;
      
        //if null
        if(root==null) return list;
        
        //keep putting left pointers
        while(root!=null || !stack.isEmpty())
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            
            }
            
            //if leaf node, go to right of parent/top after printing current root
            TreeNode top=stack.pop();    
            list.add(top.val);
            if(top.right!=null) root=top.right;
            
            
        }
        
        return list;
    }
}