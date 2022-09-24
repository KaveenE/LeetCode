package medium;/*
-Diagonal elements have same (colIdx+rowIdx)
    -If even, moving up+right
    -If odd, moving down+left
-4 cases when moving
    -got row, got col
    -got row, no col
    -no row, got col
    -no row, no col

*/

import java.util.ArrayList;
import java.util.List;

class Id498 {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> diagOrder = new ArrayList<>();
        
        int col=0, row=0;
        int colEnd=mat[0].length-1, rowEnd=mat.length-1;
        
        while(diagOrder.size() < mat.length*mat[0].length){
            diagOrder.add(mat[row][col]);
            
            //Moving up+right
            if((row+col)%2==0){
                if((row-1>=0 && col+1<=colEnd)){
                    row--;
                    col++;
                } else if(col+1<=colEnd){
                    col++;
                }
                else{ //for 2 cases
                    row++;
                }
            }
            //Move down+left
            else{
                if((row+1<=rowEnd && col-1>=0)){
                    col--;
                    row++;
                } else if(row+1<=rowEnd){
                    row++;
                }
                else{ //for 2 cases
                    col++;
                }
            }
        }
        
        return diagOrder.stream().mapToInt(x->x).toArray();
    }
}