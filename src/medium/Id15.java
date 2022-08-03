package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Id15 {
	// Note the solution I'm using for 3Sum is actually an extension of my failed
	// approach for 2 sum! (Link: https://github.com/KaveenE/LeetCode/tree/main/src/easy/Id1)
	// Why can it work here? My original approach for 2sum failed only cos they
	// asked to return indices.
	// Because of duplicates, the indice values were overwritten as I populated my
	// valueToIndex map
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		Set<List<Integer>> triplets = new HashSet<>();
		// 2 pointers-front/back
		int left, right;
		int target, potentialComplement;

		for (int i = 0; i <= nums.length - 2; i++) {
			target = nums[i];
			left = i + 1;
			right = nums.length - 1;

			while (right > left) {
				potentialComplement = nums[left] + nums[right];

				if ((potentialComplement + target) == 0) {
					triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
					
					//Optimize soln (doesn't reduce complexity)
					while(right-1>=left && nums[right]==nums[right-1])right--;
                    			while(left+1<=right && nums[left]==nums[left+1])left++;
					
					// Check other solns
					left++;
					right--;
				} else if ((potentialComplement + target) > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		
		return new ArrayList<>(triplets);
	}
}
