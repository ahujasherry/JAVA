/*
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 */
import java.util.*;

class Result
{
	int start,end;
	public Result()
	{
		start=-1;
		end=-1;
	}
	public Result(int start, int end)
	{
		this.start=start;
		this.end=end;
	}
	
	public String toString()
	{
		return start + " "+ end;
	}
	
	
}

public class MergeIntervals 
{
	
	public static void printList(ArrayList list)
	{
		System.out.println("final output : ");
		Iterator<Result> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next().toString()+" ");
			System.out.println("");
		}
	}
	
	public static void merge(int[][] arr,Result res,ArrayList list) 
    {
		if(arr.length==0) return ;
		//sort intervals based on starting time
		//Lambda expression
		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
		
		res.start=arr[0][0];
		res.end=arr[0][1];
		list.add(new Result(res.start,res.end));
		
		for (int i = 1; i < arr.length; i++) 
		{
			
			int s=arr[i][0];
			int e=arr[i][1];
			//System.out.println("s:"+s+" ,end:"+e);
			
			//whenever we find merge intervals, update the end and push updated to final list
			//if its not present already
			boolean isPresent= s>= res.start && e <=res.end;
			boolean inRange=s>= res.start && s <=res.end;
			
			if(inRange && !isPresent)
			{
				
				//update end, take maximum of current end and final list end
				res.end=Math.max(res.end, e);
				list.set(list.size()-1,new Result(res.start,res.end));
				
			}
			//if not merge, push mutually exclusive to final list
			else if(!isPresent)
			{
				list.add(new Result(s,e));
				res.start=s;
				res.end=e;
			}
		}
		
		//print final list
		printList(list);
		
		
		
       
        
    }
	
	public static void printInput(int [][]arr)
	{
		System.out.println("Input array: ");
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < arr[i].length; j++) 
			{
				System.out.print(arr[i][j]+ " ");
				
			}
			System.out.println("");
			
		}
	}

	public static void main(String[] args) 
	{
		final int arr[][]= {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
		printInput(arr);
		Result res=new Result();
		ArrayList<Result> list=new ArrayList<Result>();
		
		merge(arr,res,list);

	}

}











