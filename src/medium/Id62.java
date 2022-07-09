package medium;

public class Id62 {
    int waysToTraverse=0;
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m+1][n+1];
        return uniquePathsRec(m,n,memo);
    }
    
    public int uniquePathsRec(int m, int n, Integer[][] memo){
        if(memo[m][n]!=null)return memo[m][n];
        
        if(m==1 || n==1){
            memo[m][n]=1;
            return 1;
        }
        if(m==0 || n==0){
            memo[m][n]=0;
            return 0;
        }
        
        waysToTraverse= uniquePathsRec(m-1,n,memo)+uniquePathsRec(m,n-1,memo);
        memo[m][n] = waysToTraverse;
        
        return waysToTraverse;
    }
}
