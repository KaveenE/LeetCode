package medium;

class Id1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestSubSeqBT(text1,
                               text2,
                               0,
                               0,
                               new Integer[text1.length()][text2.length()]);
    }
    
    public int longestSubSeqBT(String s1, String s2, int s1Idx, int s2Idx, Integer[][] memo){
        if(s1Idx==s1.length() || s2Idx==s2.length()){
            return 0;
        }
        
        if(memo[s1Idx][s2Idx]!=null)return memo[s1Idx][s2Idx];
        
        if(s1.charAt(s1Idx)==s2.charAt(s2Idx)){
            memo[s1Idx][s2Idx] = 1+longestSubSeqBT(s1, s2, s1Idx+1, s2Idx+1, memo);
            return memo[s1Idx][s2Idx];
        }
        
        int subSeqLenskips1Idx = longestSubSeqBT(s1, s2, s1Idx+1, s2Idx, memo);
        int subSeqLenskips2Idx = longestSubSeqBT(s1, s2, s1Idx, s2Idx+1, memo);
        memo[s1Idx][s2Idx]=Math.max(subSeqLenskips1Idx, subSeqLenskips2Idx);
        return memo[s1Idx][s2Idx];
    }
}