package medium;

class Id59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int count=0; 
        //if (matrix == null || matrix.length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        int rowStart = 0,  rowEnd = row - 1;
        int colStart = 0, colEnd = col - 1;
        while (count < row * col) {
            for (int j = colStart; j <= colEnd && count<row*col; j++)
                matrix[rowStart][j]=++count;
            rowStart++;
            
            for (int i = rowStart; i <= rowEnd && count<row*col; i++)
                matrix[i][colEnd]=++count;
            colEnd--;
            
            for (int j = colEnd; j >= colStart && count<row*col; j--)
                matrix[rowEnd][j]=++count;
            rowEnd--;
            
            for (int i = rowEnd; i >= rowStart && count<row*col; i--) 
                matrix[i][colStart]=++count;
             colStart++;   

        }
        return matrix;
    }
}