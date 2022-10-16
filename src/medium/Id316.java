package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//We want the smallest subsequence among all possible subsequences with distinct chars
//Let's disregard brute force
class Id316 {
    public String removeDuplicateLetters(String s) {
        
        int[] charToLastIdx=new int[26];
        for(int idx=0; idx<=s.length()-1; idx++){
            charToLastIdx[s.charAt(idx)-'a']=idx;
        }
        
        Set<Character> inStack = new HashSet<>();
        Deque<Character> stack=new ArrayDeque<>();
        char currChar;
        for(int idx=0; idx<=s.length()-1; idx++){
            currChar=s.charAt(idx);
            if(!inStack.contains(currChar)){
                //if tail of stack is bigger than currChar and is present later in string
                //We can pop it and push it later on to give smaller subsequence with distinct chars
                while(!stack.isEmpty() && stack.peekLast()-currChar>0 && charToLastIdx[stack.peekLast()-'a']>idx){
                    inStack.remove(stack.removeLast());
                }
                
                stack.offerLast(currChar);
                inStack.add(currChar);
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(char c:stack)sb.append(c);
        
        return sb.toString();
    }
}