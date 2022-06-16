package easy;

import requiredClassesForSome.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Id203 {
	public ListNode removeElements(ListNode head, int val) {
		// Boundary case where we test for the first few nodes contain the value to be
		// deleted
		// If that is the case, we can use head directly
		// as we don't want those nodes to be the head in the 1st place
		while (head != null && head.val == val) {
			head = head.next;
		}

		ListNode currentNode = head;
		while (currentNode != null && currentNode.next != null) {
			if (currentNode.next.val == val) {

				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}

		}

		return head;
	}

}