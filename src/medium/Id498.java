package medium;/*
-Diagonal elements have same (colIdx+rowIdx)
    -If even, moving up+right
        - if there's available row up and col to right -> move up + right
        - else see what is not available and move accordingly
    -If odd, moving down+left
        - if there's available row down and col to left -> move down + left
        - else see what is not available and move accordingly
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
                } else if(col+1>colEnd){
                    row++;
                }
                else{ //for 2 cases
                    col++;
                }
            }
            //Move down+left
            else{
                if((row+1<=rowEnd && col-1>=0)){
                    col--;
                    row++;
                } else if(row+1>rowEnd){
                    col++;
                }
                else{ //for 2 cases
                    row++;
                }
            }
        }
        
        return diagOrder.stream().mapToInt(x->x).toArray();
    }
}
