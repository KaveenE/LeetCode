package medium;

class Id63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] memo = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        uniquePathsRec(0, 0, obstacleGrid, memo);
        return memo[0][0];
    }
    
    public int uniquePathsRec(int rowIdx, int colIdx, int[][] grid, Integer[][] memo){
        
        if(rowIdx==grid.length-1 && colIdx==grid[0].length-1 && grid[rowIdx][colIdx]!=1){
            return memo[rowIdx][colIdx]=1;
        }
        
        if(rowIdx>grid.length-1 || colIdx>grid[0].length-1){
            return 0;
        }
        
        if(grid[rowIdx][colIdx]==1){
            return memo[rowIdx][colIdx]=0;
        }
        
        if(memo[rowIdx][colIdx]!=null)return memo[rowIdx][colIdx];
        
        return memo[rowIdx][colIdx] = uniquePathsRec(rowIdx+1, colIdx, grid, memo)+uniquePathsRec(rowIdx, colIdx+1, grid, memo);
    }
}