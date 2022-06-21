package easy;

import java.util.HashMap;
import java.util.Map;

public class Id383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length())
			return false;

		Map<Character, Integer> targetMap = new HashMap<>();

		for (char c : ransomNote.toCharArray()) {
			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
		}

		// To cache letters in window if letters are in targetMap
		Map<Character, Integer> windowMap = new HashMap<>();

		int start = 0, end = 0;
		int counter = 0;

		while (end <= magazine.length() - 1) {
			char c = magazine.charAt(end);

			if (targetMap.containsKey(c)) {
				windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

				if (windowMap.get(c)
					.equals(targetMap.get(c))) {
					counter++;
				}
			}

			end++;

			if (counter == targetMap.size()) {
				return true;
			}
		}

		return false;
	}
}
