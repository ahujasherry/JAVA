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
    
    //leftStack: inoder
    //rightStack : reverse inorder
    //rest same as normal array of 2 pointers
    public boolean findTarget(TreeNode root, int k)
    {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        
        initStack(leftStack, root, true);
        initStack(rightStack, root, false);
    
        while(leftStack.peek() != rightStack.peek() )
        {
            
                int sum = leftStack.peek().val + rightStack.peek().val;
                if (sum == k) {
                    return true;
                } else if (sum > k) 
                {
                    TreeNode front=rightStack.pop();
                    if(front.left!=null)
                    {
                        front=front.left;
                        while(front!=null)
                        {
                            rightStack.push(front);
                            front=front.right;
                        }
                    }                            
            } else 
            {
                TreeNode front=leftStack.pop();
                if(front.right!=null)
                {
                    front=front.right;
                    while(front!=null)
                    {
                        leftStack.push(front);
                        front=front.left;
                    }
                }
                
               
            }
            
        }
        return false;
    }
    
    public static void initStack(Stack<TreeNode> stack, TreeNode node, boolean                                               isLeft) 
    {
        TreeNode cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = isLeft ? cur.left : cur.right;
        }
    }
}