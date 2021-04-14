class block {
    int data;
    block left, right;
 
    public block(int data)
    {
        this.data = data;
        left = right = null;
    }
}
 
class InorderPostorderBT {
   static int postEnd;
    public InorderPostorderBT(int n)
    {
        postEnd=n-1;
    }
    public block buildUtil(int in[], int post[], int inStrt,
                   int inEnd)
    {
        if (inStrt > inEnd)
            return null;
 
        block node = new block(post[postEnd--]);
 
        if (inStrt == inEnd)
            return node;
        
        int iIndex = search(in, inStrt, inEnd, node.data);
 
         node.right= buildUtil(in, post, iIndex + 1, inEnd);

        node.left = buildUtil(in, post, inStrt, iIndex - 1);
           
        
        return node;
    }
 
    
    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }
 
    void preOrder(block node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
 
    public static void main(String[] args)
    {
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        InorderPostorderBT tree = new InorderPostorderBT(n);
        
        block root= tree.buildUtil(in, post, 0, n - 1);
        System.out.println(
            "Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}