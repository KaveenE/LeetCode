package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Naive: O(n) (amortized too)
```````````````````````````
- To dequeue, pop from stack to reversedStack
- Now reversedStack's head contains the elem to dequeue.
- Pop back reversedStack into stack

Optimized: O(n) but O(1) amortized
`````````````````````````````````
- Just like naive but omit 3rd step. Since, we only need to do stack.push(), the stack doesn't need to have elements.
- When reversedStack is empty for dequeue, simply do naiive's first 2 steps
*/

public class Id232 {
	private Deque<Integer> stack;
	private Deque<Integer> reversedStack;

	public Id232() {
		stack = new ArrayDeque<>();
		reversedStack = new ArrayDeque<>();
	}

	public void push(int x) {
		stack.offerFirst(x);
	}

	public int pop() {
		if (reversedStack.isEmpty()) {
			while (!stack.isEmpty()) {
				reversedStack.offerFirst(stack.pollFirst());
			}
		}

		return reversedStack.pollFirst();
	}

	public int peek() {
		if (reversedStack.isEmpty()) {
			while (!stack.isEmpty()) {
				reversedStack.offerFirst(stack.pollFirst());
			}
		}

		return reversedStack.getFirst();
	}

	public boolean empty() {
		return stack.isEmpty() && reversedStack.isEmpty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
