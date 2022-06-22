package templates;

public class PrefixSum {
	
	//Qn: To output sum of values between arr[end] and arr[start]
	//In O(n) time for m queries instead of O(m*n)
	public int kadane(int[] arr, int end, int start) {
		
		//prefix[i]=arr[0], i=0
		//prefix[i]=arr[0] + ... + arr[i], i>0
		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixSum[i] = prefixSum[i-1]+arr[i]; 
		}
		
		return prefixSum[end] - prefixSum[start==0 ? start : start-1 ];
	}
}
