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
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null) return true;
        return isSymmetricHelperIter(root.left, root.right);
        
    }
    
    /*
    //Recursive
    public static boolean isSymmetricHelper(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        
        if(left.val == right.val) 
        {
            return isSymmetricHelper(left.left,right.right) &&                                                       isSymmetricHelper(left.right,right.left);
        }
        
        return false;
        
    }*/
    
    //Iterative
    public static boolean isSymmetricHelperIter(TreeNode left, TreeNode right)
    {
        
        Queue<TreeNode> q = new LinkedList();
       
        q.add(left);
        q.add(right);
        while(!q.isEmpty()){
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if(a == null && b == null)
                continue;
            if(a == null || b == null ||a.val != b.val )
                return false;
            q.add(a.left);
            q.add(b.right);
            q.add(a.right);
            q.add(b.left);
            
        }
        return true;   
    }
}