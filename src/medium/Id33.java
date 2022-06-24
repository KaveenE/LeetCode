package medium;

public class Id33 {
	public int search(int[] nums, int target) {

		int left = 0, right = nums.length - 1;
		int mid = 0;
		while (right > left) {
			mid = left + (right - left) / 2;

			// If both target and nums[mid] on the same half, do standard binary search
			if ((nums[mid] - nums[nums.length - 1]) * (target - nums[nums.length - 1]) > 0) {

				if (target == nums[mid])
					return mid;
				else if (target > nums[mid])
					left = mid + 1;
				else
					right = mid;

			}
			// target on left left, so ignore right half
			else if (target > nums[nums.length - 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		// Post-processing where left == right
		return (left != nums.length && nums[left] == target) ? left : -1;
	}
}
