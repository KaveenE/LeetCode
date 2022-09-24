package medium;

class Id48 {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        
        //Reverse elements across row/col to rotate clockwise/anticlockwise
        //I'm reversing across row
        int temp;
        for(int row=0; row<=matrix.length-1; row++){
            for(int col=0; col<=(matrix[0].length-1)/2; col++){
                temp=matrix[row][col];
                matrix[row][col]=matrix[row][matrix[0].length-1-col];
                matrix[row][matrix[0].length-1-col]=temp;
            }
        }
    }
    
    public void transpose(int[][] matrix){
        int temp;
        
        for(int row=0; row<=matrix.length-1; row++){
            for(int col=row+1; col<=matrix[0].length-1; col++){
                temp=matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;
            }
        }
    }
}