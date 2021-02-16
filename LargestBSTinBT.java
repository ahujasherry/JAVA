// A class to store a BST node
class Node
{
    int data;
 
    Node left, right;
 
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}
 
// A class to store information about a binary tree
class SubTreeInfo
{
    // `min`, `max` stores the minimum and the maximum value in the binary tree rooted
    // under the current node. They are relevant only if the `isBST` flag is true.
    int min, max;
 
    // stores size of the largest BST in the binary tree rooted under the current node
    int size;
 
    // true if a binary tree rooted under the current node is a BST
    boolean isBST;
 
    // constructor
    SubTreeInfo(int min, int max, int size, boolean isBST)
    {
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}
 
class Main
{
    // Recursive function to find the size of the largest BST in a given binary tree
    public static SubTreeInfo findLargestBST(Node root)
    {
        // Base case: empty tree
        if (root == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
 
        // Recur for the left and right subtrees
        SubTreeInfo left = findLargestBST(root.left);
        SubTreeInfo right = findLargestBST(root.right);
 
        SubTreeInfo info = null;
 
        // Check if a binary tree rooted under the current root is a BST
 
        // 1. Left and right subtree are also BST
        // 2. The value of the root node should be more than the largest value
        //    in the left subtree
        // 3. The value of the root node should be less than the smallest value
        //    in the right subtree
        if (left.isBST && right.isBST &&
            (root.data > left.max && root.data < right.min))
        {
            info = new SubTreeInfo( Math.min(root.data, Math.min(left.min, right.min)),
                                Math.max(root.data, Math.max(left.max, right.max)),
                                left.size + 1 + right.size,
                                true);
        }
        else
        {
            // If a binary tree rooted under the current root is not a BST,
            // return the largest BST size in its left and right subtree
 
            info = new SubTreeInfo(0, 0, Math.max(left.size, right.size), false);
        }
 
        return info;
    }
 
    public static void main(String[] args)
    {
        /* Construct the following binary tree
                      10
                    /    \
                   /      \
                  15       8
                 / \      / \
                /   \    /   \
               12   20  5     9
              / \      / \     \
             /   \    /   \     \
            2    14  4    7     10
        */
 
        Node root = new Node(10);
 
        root.left = new Node(15);
        root.right = new Node(8);
 
        root.left.left = new Node(12);
        root.left.right = new Node(20);
        root.right.left = new Node(5);
        root.right.right = new Node(9);
 
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(14);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);
 
        root.right.right.right = new Node(10);
 
        System.out.print("The size of the largest BST is " +
                                findLargestBST(root).size);
    }
}


