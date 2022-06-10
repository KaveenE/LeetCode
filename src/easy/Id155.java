package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Id155 {
	private Deque<Integer> stack;
	// To store the minimum at that time and update accordingly
	private Deque<Integer> minStack;

	public Id155() {
	        stack = new ArrayDeque<>();
	        minStack = new ArrayDeque<>();
	    }

	public void push(int val) {
		stack.offerFirst(val);
		if (getMin() == null || val <= getMin()) {
			minStack.offerFirst(val);
		}
	}

	public void pop() {
		if (stack.pollFirst().equals(getMin())) {
			minStack.pollFirst();
		}
	}

	public int top() {
		return stack.peekFirst();
	}

	public Integer getMin() {
		return minStack.peekFirst();
	}
}
