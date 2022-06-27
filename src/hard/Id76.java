package hard;

import java.util.HashMap;
import java.util.Map;

public class Id76 {
	 public String minWindow(String s, String t) {
	        if(t.length() > s.length())return "";        
	        
	        Map<Character,Integer> targetMap = new HashMap<>();
	        for(int i=0; i<=t.length()-1;i++){
	            targetMap.put(t.charAt(i),
	                          targetMap.getOrDefault(t.charAt(i),0)+1);
	        }
	        
	        Map<Character,Integer> windowMap = new HashMap<>();
	        int start=0, end=0;
	        int counter=0;
	        
	        //length of substring that matches target
	        //Give some baseline value
	        int len = Integer.MAX_VALUE;
	        int startMinsubstring = s.length();
	        
	        char c=s.charAt(0);
	        while(end<=s.length()-1){
	            c=s.charAt(end);
	            
	            if(targetMap.containsKey(c)){

	                windowMap.put(c,windowMap.getOrDefault(c,0)+1);
	                if(windowMap.get(c).equals(targetMap.get(c))){
	                    counter++;
	                }
	            }
	            
	            end++;
	            
	            while(targetMap.size() == counter){
	                c=s.charAt(start);
	                
	                if(targetMap.containsKey(c)){
	                    windowMap.put(c,windowMap.getOrDefault(c,0)-1);
	                    if(windowMap.get(c) < targetMap.get(c)){
	                        counter--;
	                    }
	                }

	                if(end-start < len){
	                    System.out.println(c);
	                    startMinsubstring = start;
	                    len = end-start;
	                }
	                
	                start++;
	            }
	        }
	        
	        return  len == Integer.MAX_VALUE ? "" : s.substring(startMinsubstring,startMinsubstring+len);
	    }

}
