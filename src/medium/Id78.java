package medium;

import java.util.ArrayList;
import java.util.List;

public class Id78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), nums, 0);
		return result;
	}

	void dfs(List<List<Integer>> result, List<Integer> state, int[] input, int currIdx) {

		result.add(List.copyOf(state)); // Add copy since we mutate state itself

		for (int idx = currIdx; idx <= input.length - 1; idx++) {
			state.add(input[idx]); // Add in dfs path

			dfs(result, state, input, idx + 1);
			// ATP, we have backtracked

			state.remove(state.size() - 1);// Remove from dfs path since we backtracked
		}
	}
}
