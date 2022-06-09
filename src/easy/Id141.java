package easy;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Id141 {
	public boolean hasCycle(ListNode head) {
		ListNode slowRunner = head;
		ListNode fastRunner = head;

		while ((slowRunner != null && fastRunner != null) && fastRunner.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if (slowRunner == fastRunner) {
				return true;
			}
		}

		return false;
	}
}
