/* Find majority element in an array, which has occured definitely > N/2 times 
*/

// Sorting
public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}



// Moore voting algorithm
//n/2 times
public int majorityElement3(int[] arr) 
{

    int count=1, major = arr[0];
    for (int i=0;i<arr.length: i++) 
    {
        if (arr[i]==major)
            count++;
        else
        {
            count--;
            if(count==0)
            {
                major=arr[i];
                count=1;
            }
        }
        
    }
    return ret;
}

//n/3 times, there could be 2 elements, track them
 public List<Integer> majorityElement(int[] nums) 
    {
        Integer major1 = null, major2 = null, cnt1 = 0, cnt2 = 0;
        for (Integer num : nums) 
        {
            System.out.println(major1+" "+major2);
            if (num.equals(major1)) {
                cnt1++;
            } else if (num.equals(major2)) {
                cnt2++;
            } else if (cnt1 == 0) {
                major1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                major2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = cnt2 = 0;
        for (Integer num : nums) {
            if (num.equals(major1)) cnt1++;
            else if (num.equals(major2)) cnt2++;
        }
        
        List<Integer> result = new ArrayList<>();
        if (cnt1 > nums.length / 3) result.add(major1);
        if (cnt2 > nums.length / 3) result.add(major2);
        return result;
        
    }