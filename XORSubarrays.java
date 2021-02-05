/*
	Count number of subarrays having xor equal to k
	Solution: Consider pre sum XOR of i,j .  from 0-xth index => Y and from x+1 to j as K then
	Y ^ K = pre_XOR and Y = pre_XOR ^ k
	so if we can find number of Y's ( of any lenghth it can be) maintaining that property, same number of subarrays would be there

*/

public int subXOR(int a[], int k)
{
	int count=0;
	int xor=0;

	//  map to store pre_XOR and frequecy which act as Y
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
	
	for(int i=0;i<a.length;i++)
	{
		xor=xor^ a[i];
		
		if( xor == k) count++;
		
		
		
		if(map.get(xor ^k)!=null ) 
		{
			count+=map.get(xor ^k);
		}

		if(map.get(xor)!=null)
		{
			map.put(xor,map.get(xor)+1);
		}else
		{
			map.put(xor,1);
		}	
	

	}


	return count;
}