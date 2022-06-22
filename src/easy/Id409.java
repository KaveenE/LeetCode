package easy;

import java.util.HashMap;
import java.util.Map;

public class Id409 {
	public int longestPalindrome(String s) {
		// Init character<->frequency
		Map<Character, Integer> charToFreq = new HashMap<>();

		for (int i = 0; i <= s.length() - 1; i++) {
			charToFreq.put(s.charAt(i), charToFreq.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		//For longest palindrome, all even frequencies are needed.
		//Odd frequencies will violate palindrome property so minus 1
		//Howver, odd frequencies in the middle will not violate it so we can keep 1 odd frequency, ie I add 1 at the end
		int summationEvenFrequencies = 0;
		int summationOddFrequenciesButRemoveALetter = 0;
		boolean oddLetters = false;
		for (Map.Entry<Character, Integer> entry : charToFreq.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				oddLetters = true;
				summationOddFrequenciesButRemoveALetter += (entry.getValue() - 1);
			} else {
				summationEvenFrequencies += entry.getValue();
			}
		}

		return oddLetters ? summationEvenFrequencies + summationOddFrequenciesButRemoveALetter + 1
				: summationEvenFrequencies;

	}
}
