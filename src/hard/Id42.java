package hard;

/*
1. Compared to rectangle qn, need to find firstIdxMoreThanCurrHeight from left and right instead of less
	i. Actually, we need to store the actual value rather than index thus 
	   the our first 2 for loops differ from rectangle problem
2. Compared to rectangle qn, height is not restricted by height of ith rectangle and can rise above.
	i. Thus, the condition if(waterLevel>=heights[i])trappedWater+=waterLevel-heights[i]; is necessary
*/
public class Id42 {
    public int trap(int[] heights) {
        int[] firstHeightMoreThanFromLeft = new int[heights.length];
        int[] firstHeightMoreThanFromRight = new int[heights.length];
        
        for(int i=1; i<=heights.length-1; i++){
            firstHeightMoreThanFromLeft[i]=Math.max(firstHeightMoreThanFromLeft[i-1],heights[i-1]);  
        }
        
        for(int i=heights.length-2; i>=0; i--){
            firstHeightMoreThanFromRight[i]=Math.max(firstHeightMoreThanFromRight[i+1],heights[i+1]); 
        }
        
        
        int trappedWater = 0;
        int waterLevel = 0;
        for(int i=0; i<=heights.length-1; i++){
            waterLevel = Math.min(firstHeightMoreThanFromLeft[i], firstHeightMoreThanFromRight[i]); 
            if(waterLevel>=heights[i])trappedWater+=waterLevel-heights[i];
        }
        
        return trappedWater;
    }
}
