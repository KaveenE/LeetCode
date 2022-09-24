package easy;

class Id566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c)return mat;
        
        int[][] newMat = new int[r][c];
        int rowNew=0, colNew=0;
        
        for(int row=0; row<=mat.length-1; row++){
            for(int col=0; col<=mat[0].length-1; col++){
                
                if(colNew==c){
                    colNew=0;
                    rowNew++;
                }
                newMat[rowNew][colNew]=mat[row][col];
                colNew++;
            }
        }
        
        return newMat;
    }
    
}