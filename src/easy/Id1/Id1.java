package easy.Id1;

import java.util.HashMap;
import java.util.Map;

public class Id1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valToIdx = new HashMap<>();
        
        for(int i=0;i<=nums.length-1;i++){
            valToIdx.put(nums[i],i);    
        }
          
        int complement;
        int idx1=0,idx2=0;
        
        for(int i=0; i<=nums.length-1; i++) {
        	complement = target - nums[i];
            if(valToIdx.containsKey(complement)) {
            	idx1=i;
            	idx2=valToIdx.get(complement);
            	
            	//Cannot use same element to achieve target
            	if(idx1!=idx2){
                    break;
                }
            }
        }
        
        return new int[] {idx1,idx2};
    }
   
}

