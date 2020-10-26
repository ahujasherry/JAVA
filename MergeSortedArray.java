/*
 * 
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

	1.The number of elements initialized in nums1 and nums2 are m and n respectively.
	You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * 
 * 
 * 2. in 2nd variation, in O(1) space and sizes should remain same
 * 
 */
public class MergeSortedArray 
{
	int arr1[], arr2[], m , n,count;
	
	public MergeSortedArray()
	{
		count=0;
		
		arr1= new int[]{1,2,3,5};
		arr2= new int[]{2};
		
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]>0) count++;
		}
		m=arr1.length;
		n=arr2.length;
	}


	public void sortedArray(int[] nums1, int m, int[] nums2, int n) 
    {
	        int i=m-1, j=n-1, k=m+n-1;
	        
	        while( i>=0 && j >=0)
	        {
	            if(nums1[i] > nums2[j])
	                    nums1[k--]=nums1[i--];
	            else
	                nums1[k--]=nums2[j--];
	            
	        }
	        while(j>=0) nums1[k--]=nums2[j--];
	        
	       
    }
	
	int binarySearch(int arr[], int l, int r, int x) 
    { 
	        if (r >= l) 
	        { 
	            int mid = l + (r - l) / 2; 
	  
	            if ( x <= arr[l])  return l; 
	               
	            else if (arr[r] < x) return r;
	            
	            if (arr[mid] > x) 
	                return binarySearch(arr, l, mid - 1, x); 
	            
	            return binarySearch(arr, mid + 1, r, x); 
	        } 
	        return -1; 
    } 
	
	public void mergeInPlace(int[] a, int m, int[] b, int n) 
    {
	        int i=0,j=0,temp,index;
	        
	        
	        //Binary search used in second array to find correct position to swap element of first array
	        while( i<m && j < n)
	        {
	            if(a[i] <= b[j]) i++;
	            
	            else 
	            {  
	            	temp=a[i];
	            	a[i]=b[j];
	            	index=binarySearch(b, 0, n-1, temp);
	            
	            	for(int k=0 ;k<= index-1; k++) 
            		{
	            		
	            		b[k]=b[k+1];
            		}
	            	b[index]=temp;
	            	i++;
	            	j=0;
	            	
	            }
	            
	        }
	         
	        
	        
	      
	        
	       
    }
	
	public void print(int[] nums1, int m, int[] nums2, int n, int opt)
	{
		System.out.println("array elements: ");
		
			
			for (int i = 0; i < nums1.length; i++) {
				System.out.print(nums1[i]+" ");
			}
		
		System.out.println();
		if(opt==0)
		{
			for (int i = 0; i < nums2.length; i++) {
				System.out.print(nums2[i]+" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MergeSortedArray obj=new MergeSortedArray();
		System.out.println("elements before sorting");
		obj.print(obj.arr1, obj.m, obj.arr2, obj.n,0);
		
	//	obj.sortedArray(obj.arr1, obj.count, obj.arr2, obj.n);
		obj.mergeInPlace(obj.arr1, obj.m, obj.arr2, obj.n);
		System.out.println();
		
		System.out.println("elements after sorting");
		obj.print(obj.arr1, obj.m,obj.arr2, obj.n,0);

	}

}
