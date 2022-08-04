package templates;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BackTrack {
	Object something;
	public static void main(String[] args) {
		Set<List<Integer>> l = new HashSet<>();
		System.out.println(l);
		
		l.add(Arrays.asList(1,2,3));
		System.out.println(l);
		
		l.add(Arrays.asList(2,1,3));
		System.out.println(l);
		
		l.add(Arrays.asList(2,2,3));
		System.out.println(l);

	}
	
	/* Other common params:
	 * 
	 * 1) Passing a pointer,stackIdx to know where we are in input
	 * 	  -> Usually initialize idx=stackIdx and passing as idx/idx+1 as a parameter
	 *       AVOID DUPLICATES of other DFS PATHS (same combi, diff order) but still use element of input multiple times /
	 *       OPTIONALLY use element of input ONCE for STATE
	 *  	
	 *  	NOTE: SORT input before dfs. 
	 *  	Works in conjunction with idx=stackIdx to OPTIONALLY use element of input ONCE for STATE + handle duplicate states that may form from some parent node
	 *      -> Add if(i>stackIdx && nums[i] == nums[i-1]) continue; at start of for loop
	 *       
	 * 2) Passing boolean[] used  in place of idx=stackIdx
	 * 	  -> if(used[i]) continue; at start of for loop
	 *       MUST use each element of input ONCE for STATE
	 *       
	 *    -> if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; at start of for loop
	 *    	 MUST use each element of input ONCE for STATE+ handle duplicate states that may form from some parent node
			 **Input must be sorted(just like above) to handle the duplicate
			
	 * 3) Passing idx/ idx+1/ boolean[] used will create states that are
	 * 	  -> Subsequence (with repeated values)/ subsequences/ subsets of inputs
	 *    -> Note the terms such as subsequences/subsets used are based on the meaning from notes 
	 */
	<T> void backTrackWithState(List<List<T>> result, List<T> state, List<T> input/*other common params*/) {
		
		if(isSolution(state)) {
			result.add(List.copyOf(state)); // Add copy since we mutate state itself
			return;
		}
		if(cantBeSolution(state)) {
			//Prune
			return;
		}
		
		for(int idx=0; idx<=input.size()-1; idx++) {
			state.add(input.get(idx)); //Add in dfs path
			backTrackWithState(result,state,input/*other common params*/);
			//ATP, we have backtracked
			state.remove(state.size()-1);//Remove from dfs path since we backtracked
			
		}
	}
	
	<T> Object backTrackWithTarget(T target, List<T> input, int stackIdx) {

		if (isSolution(target)) {
			return something;
		}
		if (cantBeSolution(target)) {
			//Prune
			return something;
		}

		for (int idx = stackIdx; idx <= input.size() - 1; idx++) {
			Object returnVal = backTrackWithTarget(add/deduct input[idx] from target, input, idx+1);
			
			if(returnVal passes cond) {
				//Do some logic such as updating max/min or others
				//For DP problems using top-down, memoization sometimes is done here
			}
		}
	}
	
	<T> boolean isSolution(List<T> state) {
		return true;
	}

	<T> boolean cantBeSolution(List<T> state) {
		return true;
	}
	
	<T> boolean isSolution(T state) {
		return true;
	}

	<T> boolean cantBeSolution(T state) {
		return true;
	}

}
