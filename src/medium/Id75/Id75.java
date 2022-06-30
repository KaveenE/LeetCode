package medium.Id75;

public class Id75 {
	public void sortColors(int[] nums) {
		//quicksort(nums, 0, nums.length - 1);
		DutchNationalFlag(nums);
	}

	public void quicksort(int[] nums, int left, int right) {
		if (left >= right)
			return;

		int partitionIdx = partition(nums, left, right);

		quicksort(nums, left, partitionIdx - 1);
		quicksort(nums, partitionIdx + 1, right);
	}

	public int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int middle = left;

		for (int counter = left + 1; counter <= right; counter++) {
			if (nums[counter] < pivot) {
				middle++;
				swap(nums, counter, middle);
			}
		}

		swap(nums, left, middle);
		return middle;
	}

	public void swap(int[] nums, int pos1, int pos2) {
		int valAtPos1 = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = valAtPos1;
	}

	// Works for sorting any 3 unique elements in-place
	// Variant of quicksort's 2 way partition. Is 3-way.
	public void DutchNationalFlag(int[] nums) {
		int low = 0, high = nums.length - 1;
		int mid = low;

		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(nums, low, mid);
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else if (nums[mid] == 2) {
				swap(nums, mid, high);
				high--;
			}
		}
	}
}
