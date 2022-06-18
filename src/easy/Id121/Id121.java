package easy.Id121;

import java.util.stream.IntStream;

public class Id121 {
	public int maxProfit(int[] prices) {

		int min = prices[0];
		int profit = 0;

		// Iterate array from left to right->Update min price
		// Since left to right iteration,
		// we're getting the lower indexed prices ie earlier days to buy lower price

		for (int currPrice : prices) {
			min = Math.min(min, currPrice);
			profit = Math.max(profit, currPrice - min);
		}

		return profit;

	}

	/* Transform [a0,a1,a2...aN] to [b0,b1,b2...bN] where
	 * b0 = a0 - a0
	 * b[i] = a[i] - a[i-1], i > 0
	 * 
	 * Notice that b[i] + b[i+1] + b[i+2] = a[i+2] - a[i-1] 
	 * 
	 * Eg:
	 * b3 = a3 - a2
	 * b4 = a4 - a3
	 * b5 = a5 - a4
	 * 
	 * b3 + b4 + b5 = a5 - a2 (all the middle terms are cancelled out)
	 * 
	 * Because of this applying kadane's algorithm on transformed array will get you answer
	 */
	public int maxProfitKadane(int[] prices) {
		
		int[] arr = IntStream.range(0, prices.length)
			.map(idx -> idx == 0 ? 0 : prices[idx] - prices[idx - 1])
			.toArray();

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
