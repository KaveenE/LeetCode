package medium;

import java.util.ArrayDeque;
import java.util.Deque;

class Id150 {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		int operand1;
		int operand2;
		for (int i = 0; i <= tokens.length - 1; i++) {

			if (isOperater(tokens[i])) {

				operand1 = stack.pollFirst();
				operand2 = stack.pollFirst();

				// Note the order. It's operand2 on the LHS of operator.
				// Imagine example
				if (tokens[i].equals("+")) {
					stack.offerFirst(operand2 + operand1);
				} else if (tokens[i].equals("-")) {
					stack.offerFirst(operand2 - operand1);
				} else if (tokens[i].equals("/")) {
					stack.offerFirst(operand2 / operand1);
				} else if (tokens[i].equals("*")) {
					stack.offerFirst(operand2 * operand1);
				}

			} else {

				stack.offerFirst(Integer.valueOf(tokens[i]));
			}

		}

		return stack.pollFirst();
	}

	public boolean isOperater(String c) {
		return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
	}
}
