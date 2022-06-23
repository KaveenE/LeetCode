package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Id47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		dfs(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
	}

	void dfs(List<List<Integer>> result, List<Integer> state, int[] input, boolean[] used) {

		if (state.size() == input.length) {
			result.add(List.copyOf(state)); // Add copy since we mutate state itself
			return;
		}

		for (int idx = 0; idx <= input.length - 1; idx++) {
			if (used[idx] || idx > 0 && input[idx] == input[idx - 1] && !used[idx - 1])
				continue;

			state.add(input[idx]); // Add in dfs path
			used[idx] = true;
			dfs(result, state, input, used);
			// ATP, we have backtracked
			used[idx] = false;
			state.remove(state.size() - 1);// Remove from dfs path since we backtracked

		}
	}
}
