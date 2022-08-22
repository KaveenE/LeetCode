package easy;

import java.util.Arrays;

public class Id724 {
    public int pivotIndex(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        
        int leftSum = 0;
        for(int i=0; i<=nums.length-1; i++){
            if(leftSum == totalSum-nums[i]-leftSum)
                return i;
            leftSum+=nums[i];
        }
        
        return -1;
        
    }
    
}