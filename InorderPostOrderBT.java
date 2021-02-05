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
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        //put inorder indeces in hashmap
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        int len=inorder.length;
        
        
        TreeNode root=buildHelper(postorder.length-1,postorder, inorder, 0 ,len-1,map);
        return root;
        
    }
    public static TreeNode buildHelper(int postStart,int[] postorder, int[] inorder, int                    start, int end,HashMap<Integer,Integer> map)
    {
        //if postStart of postorder goes out of bound after jump or inorder goes out of bound
        if((start > end) ||( postStart > postorder.length-1) ) return null;
        
        //make postStart array element as root
        TreeNode node= new TreeNode(postorder[postStart]);
        
        //if leaf node
        if(start == end ) return node;
        
        //get index of inorder of node from map
        int inIndex=map.get(node.val);
        
        //left subtree will be inorder index left and right will be its right
        //postStart jump will be like postStart-1-end+inIndex
        node.left=buildHelper( postStart-1-end+inIndex,postorder,inorder,start,inIndex-1,map);
       
        //right subtree will be inorder index right
        //postStart index of right subtree is postStart index -1
        node.right=buildHelper(postStart-1,postorder,inorder,inIndex+1,end,map);
        
        return node;
        
    }
}