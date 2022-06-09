package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Id20 {
	Deque<Character> dq = new ArrayDeque<>();

	public boolean isValid(String s) {

		for (int i = 0; i <= s.length() - 1; i++) {
			if (isOpener(s.charAt(i))) {
				dq.addFirst(s.charAt(i));
			}

			if (!isOpener(s.charAt(i))) {
				if (!isMatchingOpener(s.charAt(i))) {
					return false;
				}
			}
		}

		if (!dq.isEmpty()) {
			return false;
		}

		return true;
	}

	public boolean isOpener(char c) {
		return c == '{' || c == '(' || c == '[';
	}

	public boolean isMatchingOpener(char c) {
		Character opener = dq.pollFirst();
		if (opener == null)
			return false;

		if (c == '}') {
			return opener == '{';
		}
		if (c == ']') {
			return opener == '[';
		}
		if (c == ')') {
			return opener == '(';
		}

		return false;
	}
}