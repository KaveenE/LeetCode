package medium;

import java.util.ArrayList;
import java.util.List;

public class Id54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(); 
        //if (matrix == null || matrix.length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        int rowStart = 0,  rowEnd = row - 1;
        int colStart = 0, colEnd = col - 1;
        while (res.size() < row * col) {
            for (int j = colStart; j <= colEnd; j++)
                res.add(matrix[rowStart][j]);
            rowStart++;
            
            for (int i = rowStart; i <= rowEnd; i++)
                res.add(matrix[i][colEnd]);
            colEnd--;
            
            for (int j = colEnd; j >= colStart; j--)
                res.add(matrix[rowEnd][j]);
            rowEnd--;
            
            for (int i = rowEnd; i >= rowStart; i--) 
                res.add(matrix[i][colStart]);
             colStart++;   

        }
        return res;
    }
}
