package easy;

import requiredClassesForSome.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Id83 {
	public ListNode deleteDuplicates(ListNode head) {

		ListNode currentNode = head;

		while (currentNode != null && currentNode.next != null) {

			if (currentNode.val == currentNode.next.val)// if consecutive nodes equal, we delete the node infront
			{
				// current node points to 1 node after duplicate node. Lazy deletion
				currentNode.next = currentNode.next.next;
			} else// We simply iterate reference by 1 node
			{
				currentNode = currentNode.next;
			}

		}

		return head;
	}

	//Works for unsorted and sorted too
	public ListNode deleteDuplicates2(ListNode head)
	{
		Set<Integer> seen = new HashSet<>();
		ListNode prev = null;
		ListNode dummyHead = head;

		while(dummyHead!=null){
			if(seen.contains(dummyHead.val)){
				prev.next = dummyHead.next;
			}
			else{
				seen.add(dummyHead.val);
				prev = dummyHead;
			}

			dummyHead = dummyHead.next;
		}

		return head;
	}
}