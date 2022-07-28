package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Id739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysToFirstLargerTempOnRight = new int[temperatures.length];
        //mds = monotonic decreasing stack containing indices only
        Deque<Integer> mds= new ArrayDeque<>();
        
        for(int idx=0; idx<=temperatures.length-1; idx++){
            //Violate mds
            while(!mds.isEmpty() && temperatures[mds.peekLast()]<temperatures[idx]){
                daysToFirstLargerTempOnRight[mds.peekLast()]=idx-mds.pollLast();
            }
            mds.offerLast(idx);
        }
        
        return daysToFirstLargerTempOnRight;
    }
}