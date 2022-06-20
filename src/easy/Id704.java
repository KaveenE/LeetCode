package easy;

public class Id704 {
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = (start + end) / 2;

		while (end >= start) {
			if (target == nums[mid])
				return mid;
			else if (target > nums[mid])
				start = mid + 1;
			else if (target < nums[mid])
				end = mid - 1;

			mid = (start + end) / 2;
		}

		return -1;
	}
}
