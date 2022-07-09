package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Id17 {
    Map<Character,String> digitToLetters = Map.of(
    		'2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.isEmpty())
			return res;

		letterCombBackTrack(res, new StringBuilder(), digits, 0);
		return res;
	}

	public void letterCombBackTrack(List<String> res, StringBuilder state, String input, int stackIdx) {
		if (input.length() == state.length()) {
			res.add(new String(state));
			return;
		}

		String letters = digitToLetters.get(input.charAt(stackIdx));
		for (int idx = 0; idx <= letters.length() - 1; idx++) {
			state.append(letters.charAt(idx));
			letterCombBackTrack(res, state, input, stackIdx + 1);
			state.deleteCharAt(state.length() - 1);
		}
	}
}
