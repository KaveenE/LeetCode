package medium;

class Id915 {
    //leftMax is located between leftStart=0 and leftEnd
    //nums[leftEnd+1] to nums[nums.length-1] should be >=leftMax
    //But if it's < leftMax, we have to update leftEnd and thus leftMax too since the window of left has changed
    public int partitionDisjoint(int[] nums) {
        int leftMax=nums[0];
        int leftEnd=0;
        int maxSoFar=nums[0];
        
        for(int currIdx=1; currIdx<=nums.length-1; currIdx++){
            maxSoFar=Math.max(maxSoFar,nums[currIdx]);
            if(nums[currIdx] < leftMax){
                leftEnd=currIdx;
                leftMax=maxSoFar;
            }
        }
        
        return leftEnd+1;
    }
}