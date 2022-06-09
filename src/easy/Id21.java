package easy;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Id21 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode tempList1 = list1;
		ListNode tempList2 = list2;
		ListNode mergedList = new ListNode();
		ListNode mergedListCopy = mergedList;

		while (tempList1 != null && tempList2 != null) {
			if (tempList1.val <= tempList2.val) {
				mergedList.next = tempList1;
				tempList1 = tempList1.next;
			} else {
				mergedList.next = tempList2;
				tempList2 = tempList2.next;
			}
			mergedList = mergedList.next;
		}

		while (tempList1 != null) {
			mergedList.next = tempList1;
			tempList1 = tempList1.next;
			mergedList = mergedList.next;
		}
		while (tempList2 != null) {
			mergedList.next = tempList2;
			tempList2 = tempList2.next;
			mergedList = mergedList.next;
		}

		return mergedListCopy.next;
	}
}
