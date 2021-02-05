class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) 
    {
        List<List<Integer>> list = new ArrayList<>();
         Arrays.sort(arr);
       
        backtrack(list, new ArrayList<>(), arr, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int                    [] arr, int remain, int start)
    {
        
        if(remain<0) return;
        
        else if (remain==0)
        {
            list.add(new ArrayList<>(tempList));
        }else{
            
            for(int i=start;i<arr.length;i++)
            {
                tempList.add(arr[i]);
                backtrack(list,tempList, arr, remain-arr[i], i);
                tempList.remove(tempList.size() - 1);
            }
        
            }
        
    }
}