package hard.Id224;

import java.util.ArrayDeque;
import java.util.Deque;

public class Id224 {
	public int calculate(String s) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;

		for (int i = 0; i <= s.length() - 1; i++) {
			if (Character.isDigit(s.charAt(i))) {
				number = number * 10 + s.charAt(i) - '0';
			} else if (s.charAt(i) == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (s.charAt(i) == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (s.charAt(i) == '(') {
				dq.addFirst(result);
				dq.addFirst(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result += sign * number;
				number = 0;
				sign = 1;
				result *= dq.removeFirst(); // For polarity
				result += dq.removeFirst();
			}
		}

		result += sign * number;

		return result;
	}

}