package medium;

import java.util.HashMap;
import java.util.Map;

public class Id532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        
        int pairs=0;
        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            //For difference of 0, we need 2 of the same number
            if(k==0){
                if(freq.containsKey(k+entry.getKey()) && freq.get(k+entry.getKey())>=2){
                    pairs++;
                }
            }
            else{
                if(freq.containsKey(k+entry.getKey())){
                    pairs++;   
                }
            }
        }
        
        return pairs;
    }
}
