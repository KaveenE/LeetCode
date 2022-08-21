package medium;

import java.util.HashSet;
import java.util.Set;

//Standard warfare in sub-matrix traversal:
//colIdx/subSetRows and colIdx%subSetCols gives local idx of subset
//subSetRows*(rowIdx/subSetRows)  and subSetCols*(rowIdx%subSetCols) gives offset from 0
//the offset + local idx gives absolute idx respectively
public class Id36 {
    public static final int THREE = 3;
    
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Set<Character> subSet = new HashSet<>();
        
        for(int row=0; row<=board.length-1; row++){
            
            for(int col=0; col<=board[row].length-1; col++){
                if(board[row][col]!='.' && !rowSet.add(board[row][col])){
                    return false;
                }
                
                if(board[col][row]!='.' && !colSet.add(board[col][row])){
                    return false;
                }
                
                int offsetRow = THREE*(row/THREE);
                int offsetCol = THREE*(row%THREE);
                
                int localRowIdx = col/THREE;
                int localColIdx = col%THREE;
                
                if(board[offsetRow+localRowIdx][offsetCol+localColIdx]!='.' && !subSet.add(board[offsetRow+localRowIdx][offsetCol+localColIdx])){
                    return false;
                }
            }
            
                 rowSet = new HashSet<>();
                 colSet = new HashSet<>();
                 subSet = new HashSet<>();
        }
        
        return true;
    }
}