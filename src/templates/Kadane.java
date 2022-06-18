package templates;

public class Kadane {

	public int kadane(int[] arr) {
		int maxSubArraySumOverall = arr[0];
		int[] maxSubArraySum = new int[arr.length];
		maxSubArraySum[0] = arr[0];
		
		//Start from idx=1 as variables are alr initialized with arr[0]
		for (int i = 1; i < arr.length; i++) {
			//If arr[i] > maxSubArraySum[i-1]+arr[i], this i is start of window for maxSubArraySumOverall
			maxSubArraySum[i] = Math.max(arr[i],maxSubArraySum[i-1]+arr[i]); 
			//If maxSubArraySum[i] > maxSubArraySumOverall, this i is end of window for maxSubArraySumOverall
			maxSubArraySumOverall = Math.max(maxSubArraySumOverall,maxSubArraySum[i]); 
		}
		
		return maxSubArraySumOverall;
	}
}
