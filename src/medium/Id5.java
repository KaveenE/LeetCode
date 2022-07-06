package medium;

public class Id5 {
	public String longestPalindrome(String s) {
		// palindrome[startLetter][endLetter]=true implies s[startLetter]..s[endLetter]
		// is a palindrome
		// Rmb that palindrome[startLetter][endLetter]=true implies
		// s[startLetter]==s[endLetter] && palindrome[startLetter+1][endLetter-1]=true
		boolean[][] palindrome = new boolean[s.length()][s.length()];

		int longestPalLen = 1;
		int longestPalStartIdx = 0;

		// Every letter by itself is a palindrome
		for (int idx = 0; idx <= palindrome.length - 1; idx++) {
			palindrome[idx][idx] = true;
		}

		// Because of the 3rd comment in the 1st comment block, for the subproblem to
		// solved first
		// We have to count down for startLetter and up for endLetter
		for (int startLetter = palindrome.length - 1; startLetter >= 0; startLetter--) {
			for (int endLetter = startLetter; endLetter <= palindrome.length - 1; endLetter++) {
				if (startLetter == palindrome.length - 1)
					continue;
				if (endLetter == 0)
					continue;

				if (s.charAt(startLetter) == s.charAt(endLetter)) {
					// endLetter shouldn't exceed startLetter hence the first condition
					if (endLetter - startLetter == 1 || palindrome[startLetter + 1][endLetter - 1]) {
						palindrome[startLetter][endLetter] = true;

						if (endLetter - startLetter + 1 > longestPalLen) {
							longestPalLen = endLetter - startLetter + 1;
							longestPalStartIdx = startLetter;
						}
					}
				}
			}
		}

		return s.substring(longestPalStartIdx, longestPalStartIdx + longestPalLen);
	}
}
