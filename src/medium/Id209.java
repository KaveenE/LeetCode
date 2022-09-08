package medium;

import java.util.HashMap;
import java.util.Map;

public class Id209 {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum=0;
        Map<Integer,Integer> windowMap = new HashMap<>();
        int start=0, end=0;
        
        int len=Integer.MAX_VALUE;
        while(end<=nums.length-1){
            windowMap.put(nums[end], windowMap.getOrDefault(nums[end],0)+1);
            windowSum+=nums[end];

            end++;

            while(windowSum>=target){
                windowMap.put(nums[start], windowMap.get(nums[start])-1);
                windowSum-=nums[start];
                
                len=Math.min(len, end-start);
                start++;
            }
        }
        
        return len==Integer.MAX_VALUE ? 0:len;
        
    }
    
}
