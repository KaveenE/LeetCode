package medium;

import java.util.ArrayList;
import java.util.List;

public class Id46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
	}

	void dfs(List<List<Integer>> result, List<Integer> state, int[] input, boolean[] used) {

		if (state.size() == input.length) {
			result.add(List.copyOf(state)); // Add copy since we mutate state itself
			return;
		}

		for (int idx = 0; idx <= input.length - 1; idx++) {
			if (!used[idx]) {
				state.add(input[idx]); // Add in dfs path
				used[idx] = true;
				dfs(result, state, input, used);
				// ATP, we have backtracked
				used[idx] = false;
				state.remove(state.size() - 1);// Remove from dfs path since we backtracked
			}
		}
	}
}
