package easy;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Id160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int sizeA = getListSize(headA);
		int sizeB = getListSize(headB);

		int nodesToSkip = Math.abs(sizeA - sizeB);

		if (sizeA >= sizeB) {
			return getIntersectionNodeAfterSkipping(nodesToSkip, headA, headB);
		}

		if (sizeB >= sizeA) {
			return getIntersectionNodeAfterSkipping(nodesToSkip, headB, headA);
		}
		return null;
	}

	public int getListSize(ListNode node) {
		int i = 0;
		while (node != null) {
			i++;
			node = node.next;
		}
		return i;
	}

	public ListNode getIntersectionNodeAfterSkipping(int nodesToSkip, ListNode longerList, ListNode shorterList) {
		for (int i = 1; i <= nodesToSkip; i++) {
			longerList = longerList.next;
		}
		while (longerList != null && shorterList != null) {
			if (longerList == shorterList) {
				return shorterList;
			}
			longerList = longerList.next;
			shorterList = shorterList.next;
		}

		return null;
	}
}