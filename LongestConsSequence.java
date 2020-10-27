import java.util.*;

/*
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 */
public class LongestConsSequence
{
	    int ans[];
	    public  void init(int n)
	    {
	        ans=new int[n];
	        for(int i=0;i<n;i++)
	        {
	            ans[i]=1;
	        }
	    }
	    public static void print(int arr[])
	    {
	    	for(int a:arr)
	    	{
	    		System.out.print(a+" ");
	    	}
	    	System.out.println("");
	    	
	    }
	    
	    //time complexity= O(nlogn)+ O(n)
	    public int longestConsecutive(int[] arr) 
	    {
	    	 if(arr.length==0) return 0;
	        Arrays.sort(arr);
	        print(arr);
	        this.init(arr.length);
	        
	        for(int i=1;i<arr.length;i++)
	        {
	           if(( arr[i-1]+1) ==arr[i] )
	           {
	               ans[i]=Math.max(ans[i-1]+ans[i],ans[i]);
	           }
	           else if((arr[i-1] ==arr[i]))
	            {
	                ans[i]=ans[i-1];
	            }
	            
	            
	            
	        }
	        
	        int max_seq=0;
	        for(int i=0;i<ans.length;i++)
	        {
	            max_seq=Math.max(max_seq,ans[i]);
	        }
	        return max_seq;
	        
	        
	    }
	    
	    //best time complexity= O(n)
	    public static int findLongestConseqSubseq(int arr[])
	    {
	    	int n=arr.length;
	        HashSet<Integer> S = new HashSet<Integer>();
	        int ans = 0;
	 
	        //adding all elements to hash set
	        for (int i = 0; i < n; ++i)
	            S.add(arr[i]);
	 
	        // check each possible sequence from the start
	        // then update optimal length
	        for (int i = 0; i < n; ++i) {
	           
	        	// if current element is the starting point of subseq
	            if (!S.contains(arr[i] - 1)) {
	                // Then check for next elements
	                // in the sequence
	                int j = arr[i];
	                while (S.contains(j))
	                    j++;
	 
	                // global ans update
	                if (ans < j - arr[i])
	                    ans = j - arr[i];
	            }
	        }
	        return ans;
	    }
	
	public static void main(String[] args) 
	{
		LongestConsSequence obj=new LongestConsSequence();
		int arr[]=new int[] {0,1,1,2,3};
		System.out.println(obj.findLongestConseqSubseq(arr));

	}

}
