package medium;

/*
    Intutition: Move img2 around till we get most overlap
    Idea:
    - Move the second image around such that it start with bottom right corner of img2 not overlapping with img1
    - For each placement of img2, we see the most overlaps we can get for that placement
        -The first nested loop determines the placement
    - Get the biggest overlap among all the placements
    
*/
class Id835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int maxOverlaps=0;
        //Constructing placements where img2 is offsetted
        for(int offsetRowFromImg1=-img1.length-1; offsetRowFromImg1<=img1.length-1; offsetRowFromImg1++){
            for(int offsetColFromImg1=-img1[0].length-1; offsetColFromImg1<=img1[0].length-1; offsetColFromImg1++){
                maxOverlaps = Math.max(maxOverlaps, overlaps(img1, img2, offsetRowFromImg1, offsetColFromImg1));
            }
        }
        
        return maxOverlaps;
    }
    
    public int overlaps(int[][] img1, int[][] img2, int offsetRow, int offsetCol){
        int offsettedRow;
        int offsettedCol;
        int overlaps=0;
        
        for(int row=0; row<=img1.length-1; row++){
            for(int col=0; col<=img1[0].length-1; col++){
                offsettedRow = row +offsetRow;
                offsettedCol = col + offsetCol;
                
                if(offsettedRow<0 || offsettedRow>img1.length-1 || offsettedCol<0 || offsettedCol>img1[0].length-1)
                    continue;
                
                
                if(img1[row][col]==1 && img2[offsettedRow][offsettedCol]==1)
                    overlaps++;
            }
        }
        
        return overlaps;
    }
}