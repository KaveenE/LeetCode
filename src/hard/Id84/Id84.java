package hard.Id84;

public class Id84 {
    public int largestRectangleArea(int[] heights) {
        int[] firstIdxLessThanFromLeft = new int[heights.length];
        int[] firstIdxLessThanFromRight = new int[heights.length];
        int firstIdxLessThanFromCurrHeight = 0;
        
        //No indices to the left/right of 0/end of array so give them invalid values
        firstIdxLessThanFromLeft[0] = -1;
        firstIdxLessThanFromRight[heights.length-1]=heights.length;
        
        for(int i=1; i<=heights.length-1; i++){
            firstIdxLessThanFromCurrHeight = i-1;
            
            while(firstIdxLessThanFromCurrHeight>=0 && heights[firstIdxLessThanFromCurrHeight]>= heights[i]){
                firstIdxLessThanFromCurrHeight = firstIdxLessThanFromLeft[firstIdxLessThanFromCurrHeight];
            }
            
            firstIdxLessThanFromLeft[i]=firstIdxLessThanFromCurrHeight;   
        }
        
        for(int i=heights.length-2; i>=0; i--){
            firstIdxLessThanFromCurrHeight = i+1;
            
            while(firstIdxLessThanFromCurrHeight<=heights.length-1 && heights[firstIdxLessThanFromCurrHeight]>= heights[i]){
                firstIdxLessThanFromCurrHeight = firstIdxLessThanFromRight[firstIdxLessThanFromCurrHeight];
            }

            firstIdxLessThanFromRight[i]=firstIdxLessThanFromCurrHeight;   
        }
        
        int maxArea = 0;
        for(int i=0; i<=heights.length-1; i++){
            //System.out.printf("%d*(%d-%d-1)\n",heights[i],firstIdxLessThanFromRight[i],firstIdxLessThanFromLeft[i]);
            maxArea = Math.max(maxArea, heights[i]*(firstIdxLessThanFromRight[i]-firstIdxLessThanFromLeft[i]-1));  
        }
        
        return maxArea;
    }

    
}