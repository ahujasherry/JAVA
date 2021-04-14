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
    /* 
  
class Solution {
    
    public static void print(TreeNode root)
    {
        if(root==null) return;
        print(root.left);
        System.out.print("ele="+root.val+" ,count="+root.count);
        System.out.println();
        print(root.right);
        
        
    }
    public int kthSmallest(TreeNode root, int k)
    {
        int temp=countLeft(root);
        
        print(root);
        
        return helper(root,k);
        
        
    }
    public static int countLeft(TreeNode root)
    {
        if(root==null) return 0;
        
        int lcount=countLeft(root.left);
        root.count=lcount;
        return lcount+ countLeft(root.right);
        
    }
    public static int helper(TreeNode root, int k)
    {
        if(root==null) return 0;
        
        if(root.count+1 == k ) return root.val;
        
         if(root.count+1 >k ) return helper(root.left,k);
        
        else  return helper(root.right,k-root.count-1);
        
    }
   
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