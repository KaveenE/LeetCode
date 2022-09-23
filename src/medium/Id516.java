package medium;

class Id516 {
    public int longestPalindromeSubseq(String s) {

        /* Pre-processing. Define basic cases. */
        int[][] longestPalLength = new int[s.length()][s.length()];

        for(int row=0; row<=longestPalLength.length-1; row++){
            longestPalLength[row][row]=1;
        }

        for(int offsetFromStart=1; offsetFromStart<=s.length()-1; offsetFromStart++){
            for(int start=0; start+offsetFromStart<=s.length()-1; start++){
                int end = start + offsetFromStart;
                if(s.charAt(start) == s.charAt(end)){
                    longestPalLength[start][end] = 2 + longestPalLength[start+1][end-1];
                }
                else{
                    longestPalLength[start][end] = Math.max(longestPalLength[start+1][end], longestPalLength[start][end-1]);
                }
            }
        }

        return longestPalLength[0][s.length()-1];

//        int[][] palLength = new int[s.length()][s.length()];
//        for(int[] row :palLength) Arrays.fill(row, -1);
//
//        return longestPalSubSeq(s, 0, s.length()-1, palLength);
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