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
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        //put inorder indeces in hashmap
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        int len=inorder.length;
        
        
        TreeNode root=buildHelper(0,preorder, inorder, 0 ,len-1,map);
        return root;
        
    }
    
    public static TreeNode buildHelper(int preStart,int[] preorder, int[] inorder, int start, int end,HashMap<Integer,Integer> map)
    {
        //if preStart of preorder goes out of bound after jump or inorder goes out of bound
        if((start > end) ||( preStart > preorder.length-1) ) return null;
        
        //make prestart array element as root
        TreeNode node= new TreeNode(preorder[preStart]);
        
        //if leaf node
        if(start == end ) return node;
        
        //get index of inorder of node from map
        int inIndex=map.get(node.val);
        
        //left subtree will be inorder index left and right will be its right
        //prestart index of left subtree is preStart +1
        node.left=buildHelper(preStart+1,preorder,inorder,start,inIndex-1,map);
       
        //right subtree will be inorder index right
        //prestart index of right subtree is preStart index + num of nodes left to inorder              index from inorder start
        node.right=buildHelper(preStart+inIndex-start+1,preorder,inorder,inIndex+1,end,map);
        
        return node;
        
    }
}