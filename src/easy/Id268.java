package easy;

import java.util.Arrays;

public class Id268 {
    public int missingNumber(int[] nums) {
        
        if(nums.length==1 && nums[0]!=0)return 0;
        
        Arrays.sort(nums);
        for(int i=1; i<=nums.length-1; i++){
            if(nums[i] != nums[i-1]+1){
                return nums[i-1]+1;
            }
        }
        
        //It may start from 0 or 1. 
        //Thus if loop maintains strictly ascending property
        //Number missing has to be nums.length or 0 respectively
        return nums[0]==0 ? nums.length : 0;
    }
}
