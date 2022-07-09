package medium;

public class Id62 {
	 int waysToTraverse=0;
	    public int uniquePaths(int m, int n) {
	        Integer[][] memo = new Integer[m+1][n+1];
	        uniquePathsIter(m,n,memo);
	        //uniquePathsRec(m,n,memo);
	        return memo[m][n];
	    }
	    
	     public void uniquePathsIter(int m, int n, Integer[][] memo){
	        for(int row=0; row<=m; row++){
	            for(int col=0; col<=n; col++){
	                if(row==0 || col==0){
	                    memo[row][col]=0;
	                    continue;
	                }
	                if(row==1 || col==1){
	                    memo[row][col]=1;
	                    continue;
	                }
	                
	                memo[row][col]=memo[row-1][col]+memo[row][col-1];
	            }
	        }
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
