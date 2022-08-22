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
            if(k==0){
                //Difference of same number gets you zerooo
                if(entry.getValue()>=2){
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