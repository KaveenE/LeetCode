package easy;

import java.util.Set;

class Id345 {
    Set<Character> vowels = Set.of('a','A',
                                   'e','E',
                                   'i','I',
                                   'o','O',
                                   'u','U');

    public String reverseVowels(String s) {
        int left = 0, right = 0;
        char leftChar, rightChar;

        StringBuilder sb = new StringBuilder(s);

        for(right=s.length()-1; right>left; right--){
            rightChar = s.charAt(right);

            if(vowels.contains(rightChar)){
                leftChar = s.charAt(left);
                while(right>left && !vowels.contains(leftChar)){
                    left++;
                    leftChar = s.charAt(left);
                }

                sb.setCharAt(left,rightChar);
                sb.setCharAt(right,leftChar);
                left++;
            }
        }

        return sb.toString();
    }
}