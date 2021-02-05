 private void permute(String str, int l, int r) 
    { 
	
        if (l == r) 
            System.out.println(str); 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); //swap start and ith
                permute(str, l+1, r); 
                str = swap(str,l,i); //backtrack
            } 
        } 
    }

 
 