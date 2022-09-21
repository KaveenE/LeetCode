package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Id416 {
	/*
	 * Le's call the 2 subsets as s1, s2.
	 * 
	 * - sum(s1)=sum(s2) => sum(nums)=sum(s1)+sum(s2) - sum(s1) = 0.5sum(nums)
	 * 
	 * All we gotta do is find a subset that adds up to 0.5sum(nums). Notice this is
	 * now similar to canSum() question I watched in DP video but doesn't reuse
	 * elements So I'll use backtracking as no overlapping subproblems
	 ** 
	 * Notice that sum(nums) must be even so if it's odd we can stright away return
	 * false;
	 */

	public boolean canPartition(int[] nums) {
		int sum = IntStream.rangeClosed(0, nums.length - 1)
			.map(i -> nums[i])
			.sum();
		if (sum % 2 != 0)
			return false;

		// Arrays.sort(nums);

		return canSum(nums, sum / 2, 0, new HashMap<>());

	}

	public boolean canSum(int[] nums, int target, int currIdx, Map<Integer, Boolean> memo) {
		if (memo.containsKey(target))
			return memo.get(target);
		else if (0 == target)
			return true;
		else if (0 > target)
			return false;
		
		boolean enteredLoop = false;
		for (int i = currIdx; i <= nums.length - 1; i++) {
			enteredLoop = true;
			if (i > currIdx && nums[i] == nums[i - 1])
				continue;
			if (canSum(nums, target - nums[i], i + 1, memo)) {
				memo.put(target, true);
				return true;
			}
		}

		if(enteredLoop)memo.put(target, false);
		return false;
	}

}
