package hard;

class Id403 {
    public boolean canCross(int[] stones) {
        if(stones[1]>1)return false;
        Boolean[][] canJumpFromStoneI = new Boolean[stones.length+1][stones.length];
        return canJump(stones, 0, 1, canJumpFromStoneI);
    }
    
    public boolean canJump(int[] stones, int stackIdx, int k, Boolean[][] canJumpFromStoneI){
        if(stackIdx>stones.length-1){
            return false;
        }
        if(stackIdx==stones.length-1){
            return true;
        }
        
        
        if(canJumpFromStoneI[k][stackIdx]!=null)return canJumpFromStoneI[k][stackIdx];
        
        boolean canJump=false;
        for(int i=stackIdx+1; i<=stones.length-1; i++){
            if(stones[i]-stones[stackIdx]>k+1)continue;
            
            //Must only try jump of 1 unit
            if(stackIdx==0){
                if(stones[i]-stones[stackIdx]==k){
                    canJump=canJump || canJump(stones, i, k, canJumpFromStoneI);
                }
            }else {
                if(stones[i]-stones[stackIdx]==k){
                    canJump=canJump || canJump(stones, i, k, canJumpFromStoneI);
                }
                else if(stones[i]-stones[stackIdx]==k-1){
                    canJump=canJump || canJump(stones, i, k-1, canJumpFromStoneI);
                }
                else if(stones[i]-stones[stackIdx]==k+1){
                    canJump=canJump || canJump(stones, i, k+1, canJumpFromStoneI);
                }
            }  

        }
        
        return canJumpFromStoneI[k][stackIdx] = canJump;
    }
}

