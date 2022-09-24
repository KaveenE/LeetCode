package easy;

class Id867 {
    public int[][] transpose(int[][] matrix) {
        //Optimize for square matrix - space O(1)
        if(matrix.length==matrix[0].length){
            int temp;
            for(int row=0; row<=matrix.length-1; row++){
                for(int col=row+1; col<=matrix[0].length-1; col++){
                    temp=matrix[row][col];
                    matrix[row][col]=matrix[col][row];
                    matrix[col][row]=temp;
                }
            }
            
            return matrix;
        }
        else{
            int[][] transposed = new int[matrix[0].length][matrix.length];
        
            for(int row=0; row<=matrix.length-1; row++){
                for(int col=0; col<=matrix[0].length-1; col++){
                    transposed[col][row]=matrix[row][col];
                }
            }
            
            return transposed;
        }
        
    }
}