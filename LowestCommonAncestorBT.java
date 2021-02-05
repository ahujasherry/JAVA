/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        /*
            if node1!=null and node2!=null then parent node is the LCA as one lie in one subtree and other in other and return it
            if node1 or node2 is null and other is not, then return it to check if that is LCA  
            or not 
        
        */
        
        if(root==null) return null;
        
        if(root==p || root==q) return root;
        
        TreeNode left_lca=lowestCommonAncestor(root.left, p, q);
        TreeNode right_lca=lowestCommonAncestor(root.right, p, q);
        
        if(left_lca!=null && right_lca!=null) return root;
        
        return (left_lca!=null)? left_lca : right_lca;
        
        
    }
}