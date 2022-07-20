package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1. Why DP?
	i. The edges are binary mutually exclusive: 
	    Choose curr job + go to next available job (start time >= end time of curr job) OR Don't choose curr job and go to next job
	ii. If you were to then draw out the tree, overlapping subproblems can be seen

2. To ensure I can go to next available job fast, will sort jobs by start time
	i. Then I can do a linear search for the next available job
	ii. Or a binary search

3. Don't forget to memoize

4. Complexity = O(n*n) / O(n*logn) if linear/binary search
*/
public class Id1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[profit.length][3];
        Map<Integer,Integer> jobToMaxProfit = new HashMap<>();
        
        for(int i=0; i<= jobs.length-1; i++){
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        
        //Ascending start time
        Arrays.sort(jobs, (r1,r2)->Integer.compare(r1[0], r2[0]));
        //System.out.println(Arrays.deepToString(jobs));
        maxProfit(jobs, jobToMaxProfit, 0);
        return jobToMaxProfit.get(0);
    }
    private int maxProfit(int[][] jobs, Map<Integer,Integer> jobToMaxProfit, int currJobIdx){
        if(currJobIdx>jobs.length-1)return 0;
        if(jobToMaxProfit.containsKey(currJobIdx))return jobToMaxProfit.get(currJobIdx);

        int nextAvailableJobIdx = nextAvailableJobIdx(jobs, currJobIdx);
        
        int profitWithCurrJob = jobs[currJobIdx][2] + (nextAvailableJobIdx==-1 ? 0 : maxProfit(jobs, jobToMaxProfit, nextAvailableJobIdx));
        int profitWithoutCurrJob = maxProfit(jobs, jobToMaxProfit, currJobIdx + 1);
        
        jobToMaxProfit.put(currJobIdx, Math.max(profitWithCurrJob, profitWithoutCurrJob));
        return jobToMaxProfit.get(currJobIdx);
        
        
    }
    
    private int nextAvailableJobIdx(int[][] jobs, int currJobIdx){
//         Linear search
//         for(int i=currJobIdx+1; i<=jobs.length-1; i++){
//             if(jobs[i][0]>=jobs[currJobIdx][1]){
//                 return i;
//             }
//         }
        
//         return -1;
        
        //Binary search
        int low=currJobIdx, high=jobs.length-1;
        int mid = low + (high-low)/2;
        int ans = -1;
        
        while(low<=high){
            if(jobs[mid][0]>=jobs[currJobIdx][1]){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
            mid = low + (high-low)/2;
        }
        
        return ans;
    }
    
}
