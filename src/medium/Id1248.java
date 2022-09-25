package medium;

import java.util.HashMap;
import java.util.Map;

//Adapting prefixSum method
//Modifying Id560 Subarray Sum Equals K soln
class Id1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefixOddNumQty = new int[nums.length];
        prefixOddNumQty[0] = nums[0]%2==1 ? 1:0;
        
        for(int i=1; i<=nums.length-1; i++){
            prefixOddNumQty[i]=prefixOddNumQty[i-1] + (nums[i]%2==1 ? 1:0);
        }

        Map<Integer,Integer> prefixOddNumQtyToFreq = new HashMap<>();
        int prefixOddNumQtyAtPrevIdx=0;
        int count=0;
        for(int i=0; i<=nums.length-1; i++){
            prefixOddNumQtyAtPrevIdx=prefixOddNumQty[i]-k;
            
            if(prefixOddNumQtyToFreq.containsKey(prefixOddNumQtyAtPrevIdx)){
                count+=prefixOddNumQtyToFreq.get(prefixOddNumQtyAtPrevIdx);
            }
            if(prefixOddNumQtyAtPrevIdx==0){
                count++;
            }
            
            prefixOddNumQtyToFreq.put(prefixOddNumQty[i], prefixOddNumQtyToFreq.getOrDefault(prefixOddNumQty[i],0)+1);
        }
        
        return count;
    }
    
}