package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Id234 {
	public boolean isPalindrome(ListNode head) {
		List<Integer> arrayList = new ArrayList<>();

		while (head != null) {
			arrayList.add(head.val);
			head = head.next;
		}

		int endIdx = (arrayList.size() - 1);

		for (int i = 0; i <= ((arrayList.size() - 1) / 2); i++) {
			if (arrayList.get(i) != arrayList.get(endIdx)) {
				return false;
			}

			endIdx--;
		}

		return true;
	}
}