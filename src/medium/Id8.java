package medium;

public class Id8 {
	// Stripped -> Processed first char specially for -> for loop rest of char array
	// Check if num is > Integer.MAX and updated accordingly.
	// If sign was negative, had to update again
	// Worked because I used a double and converted to int
	public int myAtoi1(String s) {
		char[] chars = s.strip()
			.toCharArray();
		int sign = 1;
		double num = 0;

		if (chars.length == 0)
			return 0;

		// Initial processing of the +/- signs
		if (chars[0] == '-') {
			sign = -1;
		}
		// By default, sign=1 if there is no operator or '+'
		// If no operator, we have to update the number
		else if (chars[0] == '+') {
			// Do nth since I alr init sign
		} else if (Character.isDigit(chars[0])) {
			num = num * 10 + chars[0] - '0';
		} else {
			return 0;
		}

		// Subsequent processing
		for (int i = 1; i <= chars.length - 1; i++) {
			if (!Character.isDigit(chars[i]))
				break;
			num = num * 10 + chars[i] - '0';
		}

		if (num > Integer.MAX_VALUE + 0.0) {
			num = Integer.MAX_VALUE + 0.0;
			if (sign == -1) {
				num = (int) num * sign;
				num--;
				return (int) num;
			}
		}

		return (int) num * sign;

	}

	// DFA==Uses states and process.
	// Refer to
	// https://leetcode.com/problems/string-to-integer-atoi/discuss/798380/Fast-and-simpler-DFA-approach-(Python-3)
	// for diagram
	public int myAtoi(String s) {
		int num = 0, state = 0, sign = 1;

		for (char c : s.toCharArray()) {
			if (state == 0) {
				if (Character.isSpaceChar(c)) {
					continue;
				} else if (Character.isDigit(c)) {
					state = 2;
					num = num * 10 + c - '0';
				} else if (c == '+' || c == '-') {
					state = 1;
					sign = c == '-' ? -1 : 1;
				} else {
					break;
				}
			} else if (state == 1) {
				if (Character.isDigit(c)) {
					state = 2;
					num = num * 10 + c - '0';
				} else {
					break;
				}
			} else if (state == 2) {
				if (!Character.isDigit(c)) {
					break;
				} else if (num > Integer.MAX_VALUE / 10
						|| num == Integer.MAX_VALUE / 10 && (c - '0' > Integer.MAX_VALUE % 10)) {
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				} else {
					num = num * 10 + c - '0';
				}
			}
		}

		return num * sign;
	}
}
