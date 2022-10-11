package hard;

class Id403 {
    public boolean canCross(int[] stones) {
        if(stones[1]>1)return false;
        Boolean[][] canJumpFromStoneI = new Boolean[stones.length+1][stones.length];
        return canJump(stones, 0, 1, canJumpFromStoneI);
    }
    
    public boolean canJump(int[] stones, int stackIdx, int jumps, Boolean[][] canJumpFromStoneI){
        if(stackIdx>stones.length-1){
            return false;
        }
        if(stackIdx==stones.length-1){
            return true;
        }
        
        
        if(canJumpFromStoneI[jumps][stackIdx]!=null)return canJumpFromStoneI[jumps][stackIdx];
        
        boolean canJump=false;
        for(int i=stackIdx+1; i<=stones.length-1; i++){
            if(stones[i]-stones[stackIdx]>jumps+1)continue;
            
            //Must only try jump of 1 unit
            if(stackIdx==0){
                if(stones[i]-stones[stackIdx]==jumps){
                    canJump=canJump || canJump(stones, i, jumps, canJumpFromStoneI);
                }
            }else {
                if(stones[i]-stones[stackIdx]==jumps){
                    canJump=canJump || canJump(stones, i, jumps, canJumpFromStoneI);
                }
                else if(stones[i]-stones[stackIdx]==jumps-1){
                    canJump=canJump || canJump(stones, i, jumps-1, canJumpFromStoneI);
                }
                else if(stones[i]-stones[stackIdx]==jumps+1){
                    canJump=canJump || canJump(stones, i, jumps+1, canJumpFromStoneI);
                }
            }  

        }
        
        return canJumpFromStoneI[jumps][stackIdx] = canJump;
    }
}

