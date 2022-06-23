package medium;

import java.util.ArrayList;
import java.util.List;

public class Id39 {
	// Similar to howSum() in DP video but wants all combinations
	// Hence, I thought it was DP but turned out to be backtracking
	// Learnt my lessons-> All possible outcomes = DFS for backtracking
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combSums = new ArrayList<>();
		combinationSumHelper(combSums, new ArrayList<>(), candidates, target, 0, 0);

		return (combSums);
	}

	public void combinationSumHelper(List<List<Integer>> combSums, List<Integer> combSum, int[] candidates, int target,
			int combSumVal, int currIdx) {
		if (combSumVal == target)
			combSums.add(List.copyOf(combSum));
		if (combSumVal > target)
			return;

		for (int i = currIdx; i <= candidates.length - 1; i++) {
			combSum.add(candidates[i]);
			combinationSumHelper(combSums, combSum, candidates, target, combSumVal + candidates[i], i);
			combSum.remove(combSum.size() - 1);
		}

	}
}
