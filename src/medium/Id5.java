package medium;

public class Id5 {
	class Pair {
		private int longestPalStartIdx =0;
		private int longestPalLen = 1;
	}
	//Converted to bottom up from my top-down
	public String longestPalindrome(String s) {
		int n = s.length();
		int[][] longestPalSubstrLen = new int[n+1][n+1];

		for(int i=0; i<=longestPalSubstrLen.length-1; i++)
			longestPalSubstrLen[i][i]=1;

		int longestPalStartIdx =0;
		int longestPalLen = 1;
		for (int start = n - 1; start >= 0; start--) {
			for (int end = start+1; end <= n-1; end++) {
				if(s.charAt(start) == s.charAt(end)){
					if(end-start-1 == longestPalSubstrLen[start + 1][end - 1]){
						longestPalSubstrLen[start][end]=2+end-start-1;
					}
					else{
						longestPalSubstrLen[start][end]=Math.max(longestPalSubstrLen[start+1][end],longestPalSubstrLen[start][end+1]);
					}

					if(longestPalSubstrLen[start][end]>longestPalLen){
						longestPalLen=longestPalSubstrLen[start][end];
						longestPalStartIdx = start;
					}

				}
			}
		}

		return s.substring(longestPalStartIdx, longestPalStartIdx + longestPalLen);
	}

	public int longestPalindromeRec(String s, int start, int end, Integer[][] palLength, Pair pair){
		if(start>end){
			return 0;
		}
		if(start==end){
			return 1;
		}

		if(palLength[start][end]!=null)return palLength[start][end];

		if(s.charAt(start)==s.charAt(end)){
			int remainingLen = end-start-1;
			if(remainingLen == longestPalindromeRec(s, start+1, end-1, palLength, pair)) {
				palLength[start][end] = 2 + remainingLen;

				if(palLength[start][end]>pair.longestPalLen){
					pair.longestPalLen=palLength[start][end];
					pair.longestPalStartIdx=start;
				}

				return palLength[start][end];
			}
		}


		int longestPalSubstrLengthAfterStart = longestPalindromeRec(s, start+1, end, palLength, pair);
		int longestPalSubstrLengthBeforeEnd  = longestPalindromeRec(s, start, end-1, palLength,  pair);
		palLength[start][end] = Math.max(longestPalSubstrLengthAfterStart,longestPalSubstrLengthBeforeEnd);

		if(palLength[start][end]>pair.longestPalLen){
			pair.longestPalLen=palLength[start][end];
			pair.longestPalStartIdx=start;
		}
		return palLength[start][end];
	}
	public String longestPalindromeFromLC(String s) {
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
