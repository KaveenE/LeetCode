package medium;

public class Id11 {
    public int maxArea(int[] height) {
        //The widest window (using first and last line) is a good candidate, because of its width.
        int windowStart=0, windowEnd=height.length-1;
        int currWindowArea=0, maxWindowArea=0;
        
        while(windowStart<windowEnd){
            currWindowArea = (windowEnd-windowStart)*Math.min(height[windowEnd], height[windowStart]);
            maxWindowArea=Math.max(maxWindowArea,currWindowArea);
            
            //Only way for window to have a larger area is to have a higher height
            //Thus we pick the larger height and resize in hopes that the new windowStart/windowEnd's height is larger
            if(height[windowEnd] > height[windowStart]){
                windowStart++;
            }
            else{
             windowEnd--;   
            }
        }
        
        return maxWindowArea;
    }
    
}
