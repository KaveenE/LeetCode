package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Id3 {
	
	public int lengthOfLongestSubstring_1stTemplate(String s) {
        Set<Character> beenSeen = new HashSet<>();
        Deque<Character> window = new ArrayDeque<>();
        int longest = 0;
        
        for(int i=0; i<= s.length() -1; i++){
            
            if(beenSeen.contains(s.charAt(i))){
                
                while(!window.isEmpty() && !window.peekFirst().equals(s.charAt(i))) {
                    beenSeen.remove(window.pollFirst());
                }
                
                window.pollFirst();
            }
            else{
                beenSeen.add(s.charAt(i));
            }
            
            window.offerLast(s.charAt(i));
            longest = Math.max(longest, window.size());
        }
        
        return longest;
    }
	
	public int lengthOfLongestSubstring_2ndTemplate(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int start=0,end=0;
        int newStart=0;
        
        int longest = 0;        
        
        while(end <= s.length()-1){
            //If window contains already seen letter
            //Resize window appropriately and update map
            if(window.containsKey(s.charAt(end))){
                newStart = window.get(s.charAt(end));
                
                while(start<=newStart){
                    window.remove(s.charAt(start));
                    start++;
                }
            }
            
            window.put(s.charAt(end),end);
            longest = Math.max(longest, window.size());
            
            end++;
        }
        return longest;
    }
}
