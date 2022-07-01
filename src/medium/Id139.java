package medium;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Id139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = wordDict.stream()
			.collect(Collectors.toSet());
		// memo[i] == true implies subsstrings of s[0]...s[i-1] in in wordSet and
		// vice-versa
		Boolean[] memo = new Boolean[s.length() + 1];

		canSegment(s, wordSet, 0, memo);

		// Never traversed down tree to get to that point.
		if (memo[s.length()] == null)memo[s.length()] = false;

		return memo[s.length()];
	}

	private boolean canSegment(String s, Set<String> wordSet, int idxOnStack, Boolean[] memo) {
		if (idxOnStack == s.length()) {
			memo[idxOnStack] = true;
			return true;
		}

		if (memo[idxOnStack] != null) {
			return memo[idxOnStack];
		}

		for (int idx = idxOnStack; idx <= s.length() - 1; idx++) {
			if (wordSet.contains(s.substring(idxOnStack, idx + 1))) {
				if (canSegment(s, wordSet, idx + 1, memo)) {
					memo[idx + 1] = true;
					return true;
				}
			}
		}

		memo[idxOnStack] = false;
		return false;
	}
}