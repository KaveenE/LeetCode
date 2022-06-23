package templates;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BackTrack {

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
	 * 1) Passing a pointer,currIdx to know where we are in input
	 * 	  -> Usually initialize idx=currIdx and passing as idx/idx+1 as a parameter
	 *       to avoid DUPLICATES of other DFS PATHS (same combi, diff order) but still use element of input multiple times 
	 *       / use element once
	 *  	
	 *  	NOTE: Typical to SORT input before dfs. 
	 *  	Works in conjunction with idx=currIdx to avoid DUPLICATE ELEMENTS of input being stored in state
	 *      -> Add if(i>currIdx && nums[currIdx] == nums[currIdx-1]) continue; at start of for loop
	 *       
	 * 2) Passing boolean[] used  in place of idx=currIdx
	 * 	  -> if(used[i]) continue; at start of for loop
	 *       Use each element of input exactly once
	 *       
	 *    -> if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	 *    	 Use each element of input exactly once + don't use unused duplicate elements

	 */
	<T> void dfs(List<List<T>> result, List<T> state, List<T> input/*other common params*/) {
		
		if(isSolution(state)) {
			result.add(List.copyOf(state)); // Add copy since we mutate state itself
			return;
		}
		if(cantBeSolution(state)) {
			return;
		}
		
		for(int idx=0; idx<=input.size()-1; idx++) {
			if(input.get(idx) is part of solution) {
				state.add(input.get(idx)); //Add in dfs path
				
				dfs(result,state,input/*other common params*/);
				//ATP, we have backtracked
				
				state.remove(state.size()-1);//Remove from dfs path since we backtracked
			}
		}
	}
	
	<T> boolean isSolution(List<T> state) {
		return true;
	}
	
	<T> boolean cantBeSolution(List<T> state) {
		return true;
	}

}
