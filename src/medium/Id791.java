package medium;

import java.util.HashMap;
import java.util.Map;

class Id791 {
    public String customSortString(String order, String s) {
        Map<Character,Integer> charToFreq = new HashMap<>();
        for(int i=0; i<=s.length()-1; i++){
            charToFreq.put(s.charAt(i), charToFreq.getOrDefault(s.charAt(i),0)+1);
        }
        
        
        //Append letters in the order dictated by order. Freq obtained from map
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=order.length()-1; i++){
            int freq=charToFreq.getOrDefault(order.charAt(i),0);
            if(freq!=0)charToFreq.remove(order.charAt(i));
            
            for(int count=1; count<=freq; count++)
                sb.append(order.charAt(i));
            
        }
        
        //For the letters not present in order, we just append at the end
        //map now only has letters not present in order
        for(Map.Entry<Character,Integer> e: charToFreq.entrySet()){
            for(int count=1; count<=e.getValue(); count++)
                sb.append(e.getKey());
        }

        return sb.toString();
    }
}
