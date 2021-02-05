class QuickSort 
{ 
    
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
	//start i from prev index
        int i = (low-1); // index of smaller element
 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot , keep putting jth element at ith and at last swap partition ele with ith at correct index
            if (arr[j] < pivot) 
            { 
                i++; 
  	
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* arr[high] taken as partition element, return correct index of it after partition */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
  
    public static void main(String args[]) 
    { 
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    } 
} 