package easy;

public class Id70 {
	public int climbStairs(int n) {
		int[] memo = new int[n + 1];
		return climbStairsRec(n, memo);
	}

	public int climbStairsRec(int n, int[] memo) {
		if (memo[n] != 0)
			return memo[n];
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		memo[n] = climbStairsRec(n - 1, memo) + climbStairsRec(n - 2, memo);
		return memo[n];

	}
}
