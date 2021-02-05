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
    
    
    public int maxPathSum(TreeNode root) 
    {
        int max[]=new int[1];
        max[0]=Integer.MIN_VALUE;
        maxPathSumHelper1(root,max);
        return max[0];
    }
    
    /*
    //uses global variable max
    public static int maxPathSumHelper(TreeNode root)
    {
        if(root==null) return 0;
        
        int left=Math.max(maxPathSumHelper(root.left),0 );
        int right=Math.max(maxPathSumHelper(root.right),0 );
        
        //will track max global value including root
        max=Math.max(max, left+right+root.val);
        
        //return max of left or right subtree sum including root as max path sum to parent
        return  Math.max(left,right) +root.val;
        
    }*/
    
    //without use of global variable
    public static int maxPathSumHelper1(TreeNode root,int[] max)
    {
        if(root==null) return 0;
        
        int left=Math.max(maxPathSumHelper1(root.left,max),0 );
        int right=Math.max(maxPathSumHelper1(root.right,max),0 );
        
        //will track max global value including root
        max[0]=Math.max(max[0], left+right+root.val);
        
        //return max of left or right subtree sum including root as max path sum to parent
        return  Math.max(left,right) +root.val;
        
    }
}