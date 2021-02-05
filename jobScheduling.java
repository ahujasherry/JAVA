int[] JobScheduling(Job arr[], int n)
    {
        int count=0,profit=0;
        
        boolean visited[]=new boolean[n];

        int r[]=new int[2];
        Collections.sort(arr, 
                         (a, b) -> b.profit - a.profit);
        
        for(int i=0;i<n;i++)
        {
            int dead=arr[i].deadline;
           //either start from last element or deadline incase of out of bound 
	   int j=Math.min(n-1,dead-1);
		
	    //find empty slot
            while(j>=0 && visited[j]==false) j--;

            if(j>=0)
	    {
            visited[j]=true;
            count++;
            profit+=arr[j].profit;
            }
            
        }
        r[0]=count;
        r[1]=profit;
        return r;
        
    }