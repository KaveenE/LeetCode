package medium;

import java.util.ArrayList;
import java.util.List;

public class Id200 {
	private int[][] DIR_TO_MOVE = {
	        {-1,0},
	        {1,0},
	        {0,1},
	        {0,-1},
	    };
	    
	    private int neighborRow;
	    private int neighborCol;
	    
	    //Count number of connected components
	    public int numIslands(char[][] grid) {
	        boolean[][] visited = new boolean[grid.length][grid[0].length];
	        int islands = 0;
	        
	        for(int row=0; row<=grid.length-1; row++){
	            for(int col=0; col<=grid[row].length-1; col++){
	                
	                if(!visited[row][col] && grid[row][col] == '1'){
	                    dfs(grid,visited,row,col);
	                    islands++;
	                }
	            }
	        }
	        
	        return islands;
	        
	    }
	    
	    private void dfs(char[][] grid,boolean[][] visited, int srcRow,int srcCol){
	        visited[srcRow][srcCol]=true;
	        
	        for(int[] neighbor: neighbors(grid,srcRow,srcCol)){
	            
	            if(!visited[neighbor[0]][neighbor[1]]){
	                dfs(grid,visited,neighbor[0],neighbor[1]);
	            }
	        }
	    }
	    
	    private List<int[]> neighbors(char[][] grid, int srcRow,int srcCol){
	        List<int[]> neighbors = new ArrayList<>();
	        for(int i=0; i<=DIR_TO_MOVE.length-1; i++){
	            neighborRow = srcRow + DIR_TO_MOVE[i][0];
	            neighborCol = srcCol + DIR_TO_MOVE[i][1];
	            
	            if(neighborRow>=0 && 
	               neighborRow<=grid.length-1 && 
	               neighborCol>=0 &&
	               neighborCol<=grid[neighborRow].length-1 &&
	               grid[neighborRow][neighborCol] == '1'){
	                
	                neighbors.add(new int[]{neighborRow, neighborCol});
	            }
	        }
	        
	        return neighbors;
	    }
}
