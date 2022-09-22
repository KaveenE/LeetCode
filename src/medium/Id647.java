package medium;

class Id647 {
    public int countSubstrings(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        
        return countSubstringsRec(s,0,s.length()-1,memo);
    }
    
    private int countSubstringsRec(String s, int start, int end, Integer[][] memo) {
    if(start>end)
      return 0;
    if(start==end)
      return 1;
        
    if(memo[start][end]!=null)return memo[start][end];

    int totalPSCount = 0;
        
    if(isPalindrome(s, start, end))
      totalPSCount = 1;    
    
    totalPSCount+=countSubstringsRec(s, start+1, end, memo);
    totalPSCount+=countSubstringsRec(s, start, end-1, memo);
        
    // because of the above two recursive calls, since we have counted twice all 
    // palindromes from "start+1" to "end-1", let's subtract that
    totalPSCount-=countSubstringsRec(s, start+1, end-1, memo);
        
    memo[start][end]=totalPSCount;
    return totalPSCount;
  }
    
    private boolean isPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}