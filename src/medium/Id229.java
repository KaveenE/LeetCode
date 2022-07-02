package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Id229 {
	// Variation of moore algo extended to 2 majorities
	// Ie appear > n/3 times. Thus atmost 2 majorities can exist.
	// Need to check for duplicates tho...
	public List<Integer> majorityElement(int[] nums) {
		if (nums.length == 1)
			return List.of(nums[0]);

		List<Integer> numsList = new ArrayList<>();

		int majority1 = 0, count1 = 0;
		int majority2 = 0, count2 = 0;

		for (int num : nums) {
			if (num == majority1) {
				count1++;
			} else if (num == majority2) {
				count2++;
			} else if (count1 == 0) {
				majority1 = num;
				count1++;
			} else if (count2 == 0) {
				majority2 = num;
				count2++;
			}
			// Paired out by non-majority so count needs to drop
			else {
				count1--;
				count2--;
			}

			numsList.add(num);
		}

		return IntStream.of(majority1, majority2)
			.boxed()
			.filter(num -> Collections.frequency(numsList, num) >= nums.length / 3 + 1)
			.distinct()
			.collect(Collectors.toList());
	}
}