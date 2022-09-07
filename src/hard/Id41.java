package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Id41 {
    //O(nlgn): Sort -> increment lowestPositiveNotSeen as we iterate
    public int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        int lowestPositiveNotSeen = 1;
        
        for(int num:nums){
            if(num>0 && num==lowestPositiveNotSeen)
                lowestPositiveNotSeen++;
        }
        
        return lowestPositiveNotSeen;
    }
    
    //O(n) space, O(n) time: Store numbers in a set -> increment lowestPositiveNotSeen as till lowestPositiveNotSeen is not in set
    public int firstMissingPositive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int lowestPositiveNotSeen = 1;
        
        for(int num:nums){
            set.add(num);
        }
        
        while(set.contains(lowestPositiveNotSeen))
                lowestPositiveNotSeen++;
        
        return lowestPositiveNotSeen;
    }
    
    //O(1) space, O(n) time
    /*
    Missing integer, m, must be within [1,n] where n=len(nums). (If none missing, just return n+1)

    1. Iterate array + Mark cells outside of this range with some appropriate value.
    2. Iterate array + Mark for integers to show they exist.
        i. This marking is quite novel. We mark s.t if nums[i]<0, (i+1) exists in nums
        ii. I think I know how this marking was created! By "imagining" the array was sorted (idk how to phrase better)
    */
    public int firstMissingPositive(int[] nums) {
        
        //Step 1
        for(int idx=0; idx<=nums.length-1; idx++){
            if(nums[idx]<1 || nums[idx]>nums.length)
                nums[idx]=Integer.MAX_VALUE;
        }
        
        //Step 2
        for(int idx=0; idx<=nums.length-1; idx++){
            int numExists = Math.abs(nums[idx]);
            
            //if out of range elem or already marked
            if(numExists==Integer.MAX_VALUE || nums[numExists-1]<0)
                continue;
            
            //Actual marking itself
            nums[numExists-1]*=-1;
        }}
        
        for(int idx=0; idx<=nums.length-1; idx++){
            if(nums[idx]>=0)
                return idx+1;
        }
        
        return nums.length+1;
    }
}
