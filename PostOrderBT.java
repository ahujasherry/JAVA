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

    //using single stack
    public List<Integer> postorderTraversal(TreeNode curr) 
    {
        TreeNode root=curr;
        //Result list and stack
        List<Integer> list=new ArrayList<Integer>();
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
      
        //if null
        if(root==null) return list;
        
      
        while(root!=null || !stack.isEmpty())
        {
            //push every left child in stack, if not left push right child
            while(root!=null)
            {
                stack.push(root);
                if(root.left!=null)
                    root=root.left;
                if(root.right!=null)
                    root=root.right;
            }
            
            //if leaf node, go to left of parent/top after printing current root
            root=stack.pop();    
            list.add(root.val);
            
            //if left of parent node is the current node that means left is visited, visit                     right child before adding parent
            if(!stack.isEmpty() && stack.peek().left == root)
                root=stack.peek().right;
            else root=null;
            
            
        }
        return list;
        
        
    }
}

