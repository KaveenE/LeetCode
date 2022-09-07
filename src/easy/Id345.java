package easy;

import java.util.Set;

class Id345 {
    Set<Character> vowels = Set.of('a','A',
                                   'e','E',
                                   'i','I',
                                   'o','O',
                                   'u','U');

    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        char leftChar, rightChar;
        
        StringBuilder sb = new StringBuilder(s);
        
        while(left<right){
            
            if(!vowels.contains(s.charAt(left))){
                sb.setCharAt(left,s.charAt(left));
                left++;
            }
            if(!vowels.contains(s.charAt(right))){
                sb.setCharAt(right,s.charAt(right));
                right--;
            }
            if(vowels.contains(s.charAt(left)) && vowels.contains(s.charAt(right)) ){
                leftChar = s.charAt(left);
                sb.setCharAt(left,s.charAt(right));
                sb.setCharAt(right,leftChar);
                
                left++;right--;
            }
        }
        
        return sb.toString();
    }
}
