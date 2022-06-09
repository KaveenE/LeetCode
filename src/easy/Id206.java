package easy;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Id206 {
	public ListNode reverseList(ListNode head) {
		ListNode prevHead = null, currHead = head, nextHead = null;

		while (currHead != null) {

			nextHead = currHead.next;
			currHead.next = prevHead;
			prevHead = currHead;
			currHead = nextHead;

		}
		return prevHead;
	}
}