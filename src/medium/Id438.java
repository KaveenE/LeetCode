package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Id438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices=new ArrayList<>();
        if(p.length()>s.length())return indices;
        
        Map<Character,Integer> targetMap = new HashMap<>();
        for(int i=0; i<=p.length()-1; i++){
            targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i),0)+1);
        }
        
        Map<Character,Integer> windowMap = new HashMap<>();
        int start=0, end=0;
        int counter=0;
        
        char curr = 'a';
        while(end<=s.length()-1){
            curr=s.charAt(end);
            if(targetMap.containsKey(curr)){
                windowMap.put(curr, windowMap.getOrDefault(curr,0)+1);
                
                if(windowMap.get(curr).equals(targetMap.get(curr))){
                    counter++;
                }
            }
            
            end++;
            
            while(counter==targetMap.size()){
                curr=s.charAt(start);
                //System.out.printf("At idx:%d, substring: %s\n",start,s.substring(start,start+p.length()));
                if(targetMap.containsKey(curr)){
                    windowMap.put(curr, windowMap.getOrDefault(curr,0)-1);
                    
                    if(windowMap.get(curr) < targetMap.get(curr)){
                        counter--;
                    }
                }
                
                //O(n) soln
                if(end-start==p.length()){
                    indices.add(start);
                }
                
                //Initially I did O(nm) solution where isAnagram is O(m)=> Gives TLE
                // if(isAnagram(s.substring(start,start+p.length()), p)){
                //     indices.add(start);
                // }
                
                start++;
            }
        }
        
        return indices;
    }
    
    //O(m), m=length of p
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0; i<=s1.length()-1; i++){
            freq.put(s1.charAt(i), freq.getOrDefault(s1.charAt(i),0)+1);
        }
        
        for(int i=0; i<=s2.length()-1; i++){
            if(freq.get(s2.charAt(i)) == null) return false;
            if(freq.get(s2.charAt(i))==0)return false;
            freq.put(s2.charAt(i), freq.get(s2.charAt(i))-1);
        }
        
        for(Integer num:freq.values()){
            if(num!=0)return false;
        }
        
        return true;
    }
}