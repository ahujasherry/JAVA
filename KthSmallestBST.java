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
class Solution 
{
    static int count;
    /* in case we can modify TreeNode class, add lcount for every node while building
    static int count;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root==null) return 0;
        
        if(root.count+1 == k ) return root.val;
            
        if(root.count+1 >k ) return kthSmallest(root.left,k);
        
        else  return kthSmallest(root.right,k-root.count-1);
        
    }*/
    
    //in order DFS
    public int kthSmallest(TreeNode root, int k)
    {
            count=k;
           TreeNode ans=KthHelper(root);
            return ans!=null? ans.val: 0 ;
    }
    
    public static TreeNode KthHelper(TreeNode root)
    {
        if(root==null) return null;
        
        TreeNode left=KthHelper(root.left);
        if(left!=null) return left;
        count--; 
        if(count==0) return root;
         
        
        return KthHelper(root.right);
        
        
    }
}