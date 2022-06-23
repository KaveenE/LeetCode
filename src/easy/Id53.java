package easy;

public class Id53 {
	public int maxSubArray(int[] arr) {
		int maxSubArraySumOverall = arr[0];
		int maxSubArraySum;
		maxSubArraySum = arr[0];

		// Start from idx=1 as variables are alr initialized with arr[0]
		for (int i = 1; i < arr.length; i++) {
			maxSubArraySum = Math.max(arr[i], maxSubArraySum + arr[i]);
			maxSubArraySumOverall = Math.max(maxSubArraySumOverall, maxSubArraySum);
		}

		return maxSubArraySumOverall;
	}
}
