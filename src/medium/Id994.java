package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Id994 {

    private int[][] DIR_TO_MOVE = {
        {-1,0},
        {1,0},
        {0,1},
        {0,-1},
    };
    
    private int neighborRow;
    private int neighborCol;
    
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minutes = 0;
        int freshOrangesLeft = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        
        //init q with rotting oranges. Multi source.
        for(int row=0; row<=grid.length-1; row++){
            for(int col=0; col<=grid[row].length-1; col++){
                if(grid[row][col]==2){
                    q.offerLast(new int[]{row,col});
                    visited[row][col] = true;
                }
                else if(grid[row][col]==1){
                    freshOrangesLeft++;
                }
            }
        }
        
        //BFS
        int[] currVertex;
        int qSize = 0;
        boolean haveOrangesRotThisLevel=false;
        while(!q.isEmpty()){
            qSize = q.size();
            haveOrangesRotThisLevel=false;
            
            for(int i=1; i<=qSize; i++){
                currVertex = q.pollFirst();
                
                for(int[] neighbor: neighbors(grid,currVertex[0],currVertex[1])){

                    if(!visited[neighbor[0]][neighbor[1]]){
                        haveOrangesRotThisLevel = true;
                        
                        visited[neighbor[0]][neighbor[1]]=true;
                        q.offerLast(neighbor);
                        freshOrangesLeft--;
                    }
                }
            }
            
            if(haveOrangesRotThisLevel)minutes++;
            System.out.println(minutes);
        }
        
        return freshOrangesLeft==0 ? minutes:-1;
    }
    
    //Empty cells aren't vertices
    private List<int[]> neighbors(int[][] grid, int srcRow,int srcCol){
        List<int[]> neighbors = new ArrayList<>();
        for(int i=0; i<=DIR_TO_MOVE.length-1; i++){
            neighborRow = srcRow + DIR_TO_MOVE[i][0];
            neighborCol = srcCol + DIR_TO_MOVE[i][1];
            
            if(neighborRow>=0 && 
               neighborRow<=grid.length-1 && 
               neighborCol>=0 &&
               neighborCol<=grid[neighborRow].length-1 &&
               grid[neighborRow][neighborCol]!=0){
                
                neighbors.add(new int[]{neighborRow, neighborCol});
            }
        }
        
        return neighbors;
    }
}
