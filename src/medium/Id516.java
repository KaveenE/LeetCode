package medium;

import java.util.Arrays;

class Id516 {
    public int longestPalindromeSubseq(String s) {
        int[][] palLength = new int[s.length()][s.length()];
        for(int[] row :palLength) Arrays.fill(row, -1);
        
        return longestPalSubSeq(s, 0, s.length()-1, palLength);
    }
    
    public int longestPalSubSeq(String s, int start, int end, int[][] palLength){
        if(start>end){
            return 0;
        }
        if(start==end){
            return 1;
        }
        
        if(palLength[start][end]!=-1)return palLength[start][end];
        
        if(s.charAt(start)==s.charAt(end)){
            palLength[start][end] = 2 + longestPalSubSeq(s, start+1, end-1, palLength);
            return palLength[start][end];
            
        }
        
        int longestPalSebSeqLengthAfterStart = longestPalSubSeq(s, start+1, end, palLength);
        int longestPalSebSeqLengthBeforeEnd = longestPalSubSeq(s, start, end-1, palLength);
        palLength[start][end] = Math.max(longestPalSebSeqLengthAfterStart,longestPalSebSeqLengthBeforeEnd);
        return palLength[start][end];
    }
}