package medium;

import java.util.HashMap;
import java.util.Map;

class Id2131 {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> freq = new HashMap<>();
        for(String word:words)freq.put(word,freq.getOrDefault(word,0)+1);

        String reversedWord;
        int reversedWordsQty=0, origWordsQty=0;
        int wordCountInPal=0;

        int qty2SameLetterToAdd=0;
        int excess2SameLetter=0;

        for(String word:freq.keySet()){
            reversedWord = new StringBuilder(word).reverse().toString();
            reversedWordsQty=freq.getOrDefault(reversedWord,0);
            if(reversedWordsQty==0)continue;

            //doubleSameLetter
            if(reversedWord.equals(word)){
                qty2SameLetterToAdd = reversedWordsQty%2==1 ? reversedWordsQty-1:reversedWordsQty;
                wordCountInPal+= qty2SameLetterToAdd;
                excess2SameLetter+=reversedWordsQty-qty2SameLetterToAdd;
            }else{
                origWordsQty=freq.get(word);
                //We need even pairs of reversed and original words to make a palindrome
                wordCountInPal+=Math.min(origWordsQty, reversedWordsQty);
            }

        }

        //The latter condition is adding a doubleSameLetter in the middle if we have odd frequency
        return wordCountInPal*2 + (wordCountInPal%2==0 && excess2SameLetter>0? 2:0);
    }

}