package medium;

import java.util.Arrays;

public class Id912 {
	public int[] sortArray(int[] nums) {
		Arrays.sort(nums);
		return nums;
	}

	public void mergeSort(int[] array, int size) {
		// No array
		if (size <= 1) {
			return;
		} else {
			// Divide: Split arrays into equal sized sub arrays
			int mid = size / 2;
			int[] left = Arrays.copyOfRange(array, 0, mid);
			int[] right = Arrays.copyOfRange(array, mid, size);

			// Conquer:Apply recursive call, ie, mergeSort on subproblem
			mergeSort(left, left.length);
			mergeSort(right, right.length);

			// Combine
			{
				merge(array, left, right);
			}
		}
	}

	public void merge(int[] array, int[] left, int[] right) {
		int arrayIdx = 0, leftIdx = 0, rightIdx = 0;

		// Elements are placed in a sorted manner in the original array by comparing the
		// sub arrays
		// This works due to 2 reasons:
		// The 2 original sub arrays are sorted and consecutive(on same stack depth)
		while (leftIdx <= left.length - 1 && rightIdx <= right.length - 1) {
			if (left[leftIdx] <= right[rightIdx]) {
				array[arrayIdx] = left[leftIdx];
				leftIdx++;
			} else {
				array[arrayIdx] = right[rightIdx];
				rightIdx++;
			}

			arrayIdx++;
		}

		// If sub arrays don’t have equal number of elements(original array may have odd
		// number of elements)
		// There will be “unused” elements
		// These unused elements will be used to fill the original array .
		while (leftIdx <= left.length - 1) {
			array[arrayIdx] = left[leftIdx];
			arrayIdx++;
			leftIdx++;
		}

		while (rightIdx <= right.length - 1) {
			array[arrayIdx] = right[rightIdx];
			arrayIdx++;
			rightIdx++;
		}

	}
}
