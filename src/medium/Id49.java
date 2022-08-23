package medium;

import java.util.*;

/*
To check for anagrams, instead of the traditional way of 
1) caching frequency of letters in 1 string and decrementing the frequency in the other 
   to see if all reaches 0
2) You can sort both strings and see if they are equal
*/
public class Id49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedStringToRealString = new HashMap<>();
        
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String strConverted = String.valueOf(charArray);
            
            sortedStringToRealString.computeIfAbsent(strConverted, _key->new ArrayList<>());
            sortedStringToRealString.get(strConverted).add(str);
        }
        
        return new ArrayList<>(sortedStringToRealString.values());
    }
}
