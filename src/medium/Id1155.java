package medium;

import java.util.HashMap;
import java.util.Map;

class Id1155 {
    public static final int MOD = 1000000000 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        Map<Pair, Integer> pairToRolls= new HashMap<>();
        return numRollsToTargetBT(target, k , n, pairToRolls);
    }
    
    public int numRollsToTargetBT(int target, int k, int n, Map<Pair, Integer> pairToRolls) {
        Pair pair = new Pair(n,target);

        if(pairToRolls.containsKey(pair))return pairToRolls.get(pair);
        
        if(n==0 && target==0){
            pairToRolls.put(pair, 1);
            return 1;
        }
        
        if(n==0 || target==0){
            pairToRolls.put(pair, 0);
            return 0;
        }
        
        int rolls = 0;
        for(int face=1; face<=k; face++){
            if(target>=face){
                rolls = (rolls + numRollsToTargetBT(target-face, k, n-1, pairToRolls)) % MOD;
            }
     
        }

        pairToRolls.put(pair,rolls);
        return rolls;
    }
    
    static class Pair {
        int dice;
        int target;
        
        Pair(int dice, int target){
            this.dice = dice;
            this.target = target;
        }
        
        @Override
        public int hashCode(){
            int result = 1;
            int prime = 31;
            
            result = result*prime + dice;
            result = result*prime + target;
            
            return result;
        }
        
        @Override
        public boolean equals(Object o){
            if(o==this)return true;
            if(o==null)return false;
            if(this.getClass()!=o.getClass())return false;
            Pair o1 = (Pair)o;
            if(this.dice==o1.dice && this.target==o1.target)return true;
            
            return false;
        }
    }
}