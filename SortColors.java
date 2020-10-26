/*
 * most optimal Solution : Dutch flag algo
 * Divided into 4 sections: Depends upon unknown state design
 * Start - Low : 0's
 * Low - Mid : 1's
 * Mid - high : unknown
 * high - end : 2's 
 */
public class SortColors 
{
	private void swap(int a, int b, int []arr)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public void sortColors(int[] arr) 
    {
        int low=0,mid=0,high=arr.length-1;
        while(mid<=high)
        {
            switch(arr[mid])
            {
                case 0:
                    {
                        swap(low,mid,arr);
                        low++;
                        mid++;
                        break;
                    }
                case 1: 
                    {
                        mid++;
                        break;
                    }
                case 2:
                {
                    swap(mid,high,arr);
                    high--;
                    break;
                    
                }
                    
            }
            
        }
        
        System.out.print("arr after sorting: ");
        for (int i = 0; i < arr.length; i++) {
        	System.out.print(arr[i]+" ");
		}
    }
    
    public  static void main(String []args)
    {
    	int arr[]= {0,1,2,0,1,2};
    	SortColors obj=new SortColors();
    	System.out.print("arr before sorting: ");
        for (int i = 0; i < arr.length; i++) {
        	System.out.print(arr[i]+" ");
		}
        System.out.println("");
    	obj.sortColors(arr);
    }

}
