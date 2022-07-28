package medium;

public class Id134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasLeft=0, gasAccumulatedOverall=0;
        int startStn=0;
        
        for(int stn=0; stn<=gas.length-1; stn++){
            int topupAndTravelCost = gas[stn] - cost[stn];
            gasLeft+=topupAndTravelCost;
            gasAccumulatedOverall+=topupAndTravelCost;
            
            if(gasLeft<0){
                /*
                Proof why we can startStn = stn+1;
                - The topupAndTravelCost for this stn outweighed gasAccumulatedOverall (ie topupAndTravelCost for all other stns)
                - Travelling from the previous stns is thus pointless  
                  since the topupAndTravelCost for this stn will still outweigh the now smaller gasAccumulatedOverall
                */
                startStn = stn+1;
                gasLeft=0;
            }
        }
        
        //gasAccumulatedOverall must be non-negative to complete a circuit
        return gasAccumulatedOverall>=0 ? startStn:-1;
    }
    
}