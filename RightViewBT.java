public List<Integer> rightSideView(TreeNode root) 
    {
        //Resultant list
        List<Integer> res=new ArrayList<Integer>();
        
        if(root==null) return res;
        
        //Queue for keeping left/right child at each level
        Deque<TreeNode> que=new LinkedList<TreeNode>();
        
        que.add(root);
        
        while(!que.isEmpty())
        {
            int count=que.size();
            
            res.add(que.getLast().val);
                
            for(int i=0;i<count;i++)
            {
                TreeNode front=que.poll();
                if(front.left!=null) que.add(front.left);
                if(front.right!=null) que.add(front.right);
            }
            
        }
        
        
        return res;   
        
    }