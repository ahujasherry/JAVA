/*
 * 
 * 
 * There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of meeting i and F[i] is finish time of meeting i.
 * The task is to find the maximum number of meetings that can be accommodated in the meeting room. Print all meeting numbers
 */

import java.util.*;

class Meet implements Comparable<Meet>
{
	int start;
	int finish;
	int index;
	
	public Meet ()
	{
		this.start=Integer.MAX_VALUE;
		this.finish=Integer.MAX_VALUE;
		this.index=-1;
	}
	public Meet (int start,int finish, int index)
	{
		this.start=start;
		this.finish=finish;
		this.index=index;
	}
	
	public String toString()
	{
		 return this.start + " " + this.finish+ 
                 " " + this.index; 
	}
	
	@Override
	public int compareTo(Meet  o) 
	{
		if(this.finish < o.finish) return 1; 
		else if (this.finish> o.finish ) return 0;
		else 
		{
			if(this.start <= o.start) return 1;
			else return 0;
		}	
	}
}
	

public class MaximumMeetings 
{

	public static List<Integer> maxMeeting(List<Meet > list, int size )
	{
		Collections.sort(list);
		int end=list.get(0).finish;
		List<Integer> res_list=new ArrayList<Integer>();
		res_list.add(list.get(0).index+1);
		
		for(int i=1;i<list.size();i++)
		{
			if(end< list.get(i).start)
			{
				res_list.add(list.get(i).index+1);
				end=list.get(i).finish;
			}
		}
		return res_list;
		
	}
	
	public static void main(String[] args) 
	{
		
		int start_time[] = { 1, 3, 0, 5, 8, 5 };
	    int finish_time[] = { 2, 4, 6, 7, 9, 9 };  
	    
	    
	    List<Meet > list=new ArrayList<Meet >();
	    for(int i = 0; i < start_time.length; i++)
	    {
	         list.add(new Meet (start_time[i], finish_time[i],i) );
	    }
	     System.out.println(maxMeeting(list,list.size()));

	}

}
