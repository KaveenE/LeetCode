package medium;

import java.util.HashMap;
import java.util.Map;

public class Id322 {
	// Same as bestSum()
	// which I learnt from DP video when reading up on DP
	public int coinChange(int[] coins, int amount) {

		Map<Integer, Integer> amtToNumCoins = new HashMap<>();
		return coinChangeHelper(coins, amount, amtToNumCoins);

	}

	public int coinChangeHelper(int[] coins, int amount, Map<Integer, Integer> amtToNumCoins) {
		if (amtToNumCoins.containsKey(amount))
			return amtToNumCoins.get(amount);
		if (amount == 0)
			return 0;
		if (amount < 0)
			return -1;

		int numCoinsToMakeAmt = -1;
		int minNumCoinsToMakeAmt = Integer.MAX_VALUE;
		for (int i = 0; i <= coins.length - 1; i++) {
			numCoinsToMakeAmt = coinChangeHelper(coins, amount - coins[i], amtToNumCoins);

			if (numCoinsToMakeAmt != -1) {
				numCoinsToMakeAmt++;
				minNumCoinsToMakeAmt = Math.min(minNumCoinsToMakeAmt, numCoinsToMakeAmt);
			}
		}

		amtToNumCoins.put(amount, minNumCoinsToMakeAmt == Integer.MAX_VALUE ? -1 : minNumCoinsToMakeAmt);
		return minNumCoinsToMakeAmt == Integer.MAX_VALUE ? -1 : minNumCoinsToMakeAmt;
	}
}
