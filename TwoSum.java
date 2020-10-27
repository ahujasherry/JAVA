import java.util.HashMap;
import java.util.Map;


/*
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use
 *  the same element twice.
 * You can return the answer in any order.
 * 
 */
public class TwoSum {
	  HashMap<Integer,Integer> map;
		
	    
	    public TwoSum()
	    {
	        map=new HashMap<Integer,Integer>();
	    
	    }
	    
	    public int[] twoSum(int[] nums, int target) 
	    {
	    	int res[]=new int[]{-1,-1};
	    	int searchEle=0,ele=0;
	    	
	    	//build a hashmap
	    	//search for ele= target - nums[i] && and skip self element
	        //handle the duplicates as map contains the indices of last element
	        for(int i=0;i<nums.length;i++)
	        {
	            ele=nums[i];
	            searchEle=target-nums[i];
	            
	            if(map.containsKey(searchEle) && i!=map.get(searchEle))
	            {
	            	res[0]=i;
	            	res[1]=map.get(searchEle);
	            	return res;
	            
	            }
	            
	            	map.put(ele,i);
	            
	        }
	       
	        return res;
  
	    }
	public static void main(String[] args) 
	{
		TwoSum obj=new TwoSum();
		int nums[]= {3,2,4};
		int res[]=new int[2];
		res=obj.twoSum(nums, 6);
		if(res[0]==-1 && res[1]==-1)
			System.out.println("not found");
		else
			System.out.println("first: "+ nums[res[0]]+" ,second:"+nums[res[1]]);
		

	}

}
