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

		// Base case 1: Every letter by itself is a palindrome
		for (int idx = 0; idx <= palindrome.length - 1; idx++) {
			palindrome[idx][idx] = true;
		}

		// Because of the 3rd comment in the 1st comment block, for the subproblem to
		// solved first
		// We have to count down for startLetter and up for endLetter
		for (int startLetter = palindrome.length - 2; startLetter >= 0; startLetter--) {
			//endLetter has to be always infront of startLetter yo
			for (int endLetter = startLetter + 1; endLetter <= palindrome.length - 1; endLetter++) {

				if (s.charAt(startLetter) == s.charAt(endLetter)) {
					// Base case 2: 2 letter palindromes
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
