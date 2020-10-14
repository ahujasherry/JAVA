//Given a string, find its first non-repeating character

import java.util.*;

class Node
{
	int count,index;
	public Node()
	{
		count=0;
		index=-1;
	}
	public Node(int count, int index)
	{
		this.count=count;
		this.index=index;
	}
}


public class FirstNonRepeatingCharacter 
{
	static final int NO_OF_CHARS = 256; 
	private String str;
	private HashMap<Character,Node> hm;
	
	private int index;
	
	public FirstNonRepeatingCharacter(String str)
	{
		this.str=str;
		index=Integer.MAX_VALUE;
		hm=new HashMap<>(NO_OF_CHARS);
	}
	
	
	private  int firstNonRepeating()
	{
		//insert in hashmap, make count,index table
		for (int i = 0; i < str.length(); i++) 
		{
			Character c=str.charAt(i);
			
			if( hm.containsKey(c))
			{
				hm.get(c).count++;
				hm.get(c).index=i;
			}
			else 
			{
				hm.put(c, new Node(1,i));
			}
		}
		
		
		//find non repeating. It will have least index and count 1
		for (Map.Entry<Character, Node> entry: hm.entrySet())
		{
			if(entry.getValue().count==1)
			{
				index=Math.min(index, entry.getValue().index);
			}
			
		}
		return this.index;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		FirstNonRepeatingCharacter obj=new FirstNonRepeatingCharacter(str);
		int index = obj.firstNonRepeating(); 
  
        System.out.println( 
            index == Integer.MAX_VALUE 
                ? "Either all characters are repeating "
                      + " or string is empty"
                : "First non-repeating character is "
                      + str.charAt(index)); 
	}

}
