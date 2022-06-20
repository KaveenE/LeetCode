package easy;

import java.util.HashMap;
import java.util.Map;

public class Id242 {
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        Map<Character,Integer> targetMap = new HashMap<>();
        
        for(char c: s.toCharArray()){
            targetMap.put(c,targetMap.getOrDefault(c,0) + 1);
        }
        
        Map<Character,Integer> windowMap = new HashMap<>();
        
        int start = 0, end = 0;
        int counter = 0;
        
        while(end<t.length()){
            char c = t.charAt(end);
            
            if(targetMap.containsKey(c)){
                windowMap.put(c,windowMap.getOrDefault(c,0) + 1);
                
                if(windowMap.getOrDefault(c,0).equals(targetMap.get(c))){
                    counter++;
                }
            }
            else{
                return false;
            }
            
            end++;
        }
        
        return counter == targetMap.size();
    }
}
