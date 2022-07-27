package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/* 1) Compute prefixSum array
   2) Iterate input
        1. Update prefixSumToFreq map
        2. Since sum(start,end) = k = prefixSum[end]-prefixSum[start-1]
           if(prefixSumToFreq.containsKey(prefixSum[end]-k)) //i.e contains prefixSum[start-1]
                count += prefixSumToFreq.get(prefixSum[end]-k)
                
  *Optimizing to O(1) space is trivial
*/
public class Id560 {
    public int subarraySum(int[] nums, int k) {

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int idx=1; idx<=nums.length-1; idx++){
            prefixSum[idx]+=prefixSum[idx-1]+nums[idx];
        }

        Map<Integer,Integer> prefixSumToFreq = new HashMap<>();
        int prefixSumAtPrevIdx = 0;
        int count=0;
        for(int idx=0; idx<=nums.length-1; idx++){
            prefixSumAtPrevIdx=prefixSum[idx]-k;

            if(prefixSumToFreq.containsKey(prefixSumAtPrevIdx)){
                count+=prefixSumToFreq.get(prefixSumAtPrevIdx);
            }
            if(prefixSumAtPrevIdx==0){
                count++;
            }

            prefixSumToFreq.put(prefixSum[idx], prefixSumToFreq.getOrDefault(prefixSum[idx],0)+1);
        }

        return count;
    }
}