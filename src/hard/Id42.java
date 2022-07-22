package hard;

/*
1. Compared to rectangle qn, need to find biggestHeight on left and right instead of less 
    (also note it does NOT have to be the FIRST height bigger than current height)
2. Compared to rectangle qn, height is not restricted by height of ith rectangle and can rise above.
	i. Thus, the condition if(waterLevel>=heights[i])trappedWater+=waterLevel-heights[i]; is necessary
*/
public class Id42 {
    public int trap(int[] heights) {
        int[] biggestHeightOnLeft = new int[heights.length];
        int[] biggestHeightOnRight = new int[heights.length];
        
        for(int i=1; i<=heights.length-1; i++){
            biggestHeightOnLeft[i]=Math.max(biggestHeightOnLeft[i-1],heights[i-1]);  
        }
        
        for(int i=heights.length-2; i>=0; i--){
            biggestHeightOnRight[i]=Math.max(biggestHeightOnRight[i+1],heights[i+1]); 
        }
        
        
        int trappedWater = 0;
        int waterLevel = 0;
        for(int i=0; i<=heights.length-1; i++){
            waterLevel = Math.min(biggestHeightOnLeft[i], biggestHeightOnRight[i]); 
            if(waterLevel>=heights[i])trappedWater+=waterLevel-heights[i];
        }
        
        return trappedWater;
    }
}
