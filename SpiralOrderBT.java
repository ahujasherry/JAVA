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
    //BFS iterative solution
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        
        //Resultant list
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        
        if(root==null) return res;
        
        //Queue for keeping left/right child at each level
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        
        que.add(root);
        
        boolean reverseFlag=false;
        
        while(!que.isEmpty())
        {
            //list to put elements of a level
            List<Integer> level =new ArrayList<Integer>();
            int count=que.size();
            
            for(int i=0;i<count;i++)
            {
                TreeNode front=que.poll();
                if(reverseFlag==false)
                    level.add(front.val);
                else if (reverseFlag==true)
                    level.add(0,front.val);
                if(front.left!=null) que.add(front.left);
                if(front.right!=null) que.add(front.right);
            }
            res.add(level);
            reverseFlag=!reverseFlag;
            
        }
        
        
        return res;   
        
    }
}