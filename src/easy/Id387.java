package easy;

import java.util.*;

public class Id387 {
    /*3 O(n) pass:
        1. Init LinkedHashMap
        2. Get first entry with value == 1
        3. Find index of that corresponding key (letter)
    */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        
        for(int i=0; i<=s.length()-1; i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i),0)+1);
        }
        
        char firstUniqueChar='0';
        for(Map.Entry<Character,Integer> charToFreq: freq.entrySet()){
            if(charToFreq.getValue()==1){
                firstUniqueChar = charToFreq.getKey();
                break;
            }
        }
        
        for(int i=0; i<=s.length()-1; i++){
            if(s.charAt(i)==firstUniqueChar){
                return i;
            }
        }
        
        return -1;
        
    }
    
    /* 1 O(n) pass:
         1. Init LinkedHashMap.
            i. As you init, if seen.contains(letter), remove key from map
         2. Return value of first entry
       
    */
    public int firstUniqChar(String s) {
        Map<Character, Integer> charToPos = new LinkedHashMap<>();
        Set<Character> seen = new HashSet<>();
        
        for(int i=0; i<=s.length()-1; i++){
            if(seen.contains(s.charAt(i))){
                charToPos.remove(s.charAt(i));
            }
            else{
                seen.add(s.charAt(i));
                charToPos.put(s.charAt(i),i);
            }
        }
        
        Iterator<Integer> it = charToPos.values().iterator();
        if(it.hasNext()){
            return it.next();
        }
        
        return -1;
    }
}