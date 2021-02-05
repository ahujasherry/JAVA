public class MinHeap
{
	private int capacity=10;
	private int size;

	privae int arr[];

	public MinHeap(int cap)
	{
		arr=new int[capacity];
		this.size=0;
	}


	private int getParentIndex(int childIndex)
	{
		return (childIndex-1)/2;
	}

	private int getLeftChildIndex(int parentIndex)
	{
		return (2*parentIndex+1);
	}

	private int getRightChildIndex(int parentIndex)
	{
			return (2*parentIndex+2);
	}

	private  boolean hasparent(int index)
	{
			return getParentIndex(index) >=0;
	}

	private  boolean hasLeftChild(int index)
	{
			return getLeftChildIndex(index) <size;
	}

	private  boolean hasRightChild(int index)
	{
			return getRightChildIndex(index) < size;
	}

	private int leftChild(int index)
	{
			return arr[getLeftChildIndex[index]];
	}
	
	private int rightChild(int index)
	{
		return arr[getRightChildIndex[index]];	
	}

	private int parent(int index)
	{
		return arr[getParentIndex[index]];
	}

	private void swap(int  i , int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	//if array is full
	private void ensureExtraCap()
	{
		if(size==capacity)
		{
			arr=Arrays.copyOf(arr, capacity*2);
			capacity*=2;
		}

	}

	// O(1)
	public int top()
	{
		if(size!=0) return arr[0];
	}

	//swap last with first, and heapify down
	//O(logn)
	public int remove()
	{
		if(size!=0)
		{
			int ele=arr[0];
			arr[0]=arr[size-1];
			size--;
			heapifyDown();
			return item;
		}
	}

	////add at last and heapify up
	//O(logn)
	public void add(int item)
	{
		ensureExtraCap();
		arr[size]=item;
		size++;
		heapifyUp();
	}

	//while parent element > child, keep going up
	public void heapifyUp()
	{
		int index=size-1;

		while(hasparent(index) && parent[index] > arr[index])
		{
			swap(index,getParentIndex(index));
			index=getParentIndex(index);
		}
	}


	public void heapifyDown()
	{
		int index=0;

		//no need to check for right child as complete BT
		while(hasLeftChild(index) )
		{
			//go to index of smaller child of parent
			int smallerChildIndex=getLeftChildIndex(index);
			
			//if right is smaller than left, update to right
			if(hasRightChild(index) && rightChild(index) < leftChild(index) )
			{

				smallerChildIndex=getRightChildIndex(index);
			}

			//swap with smaller element
			if(arr[index] > arr[smallerChildIndex])
			{
				swap(index, smallerChildIndex);
			}else
			{
				break;
			}

			//make index as child index for next iteration
			index=smallerChildIndex;

		}
	}
	public static void main(String args[])
	{
		MinHeap minHeap= new MinHeap(10);
		minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 

        
	}
}