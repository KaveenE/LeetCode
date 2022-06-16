package templates;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public class MergeKWay {

	public int[] mergekSortedArrays(int[][] arrays) {
		if (arrays == null) {
			return new int[0];
		}

		// To form min heap with the ascending comparator
		Queue<Element> minHeap = new PriorityQueue<>(arrays.length, (elem1, elem2) -> elem1.val - elem2.val);

		// init PQ with 1st element (ie smallest)
		for (int row = 0; row < arrays.length; row++) {
			minHeap.offer(new Element(row, 0, arrays[row][0]));
		}

		/*
		 * 1. Update mergedArray with minHeap.poll() 
		 * 2. Update minHeap with next smallest element from the same list containing the polled element 
		 * 3. Repeat till we have gone through all elements, ie till minHeap.isEmpty()
		 */
		List<Integer> mergedList = new ArrayList<>();
		Element elem;
		while (!minHeap.isEmpty()) {
			elem = minHeap.poll();
			mergedList.add(elem.val);
			if (elem.col + 1 <= arrays[elem.row].length - 1) {
				elem = new Element(elem.row, elem.col + 1, arrays[elem.row][elem.col + 1]);
				minHeap.offer(elem);
			}
		}
		return mergedList.stream().mapToInt(x -> x).toArray();
	}

	public ListNode mergekSortedLinkedLists(ListNode[] linkedLists) {
		if (linkedLists == null || linkedLists.length == 0) {
			return null;
		}

		// To form min heap with the ascending comparator
		Queue<ListNode> minHeap = new PriorityQueue<>(linkedLists.length, (node1, node2) -> node1.val - node2.val);
		
		// init PQ with 1st element (ie smallest)
		for (ListNode node:linkedLists) {
			if(node!=null)minHeap.offer(node);
		}

		/*
		 * 1. Update mergedArray with minHeap.poll() 
		 * 2. Update minHeap with next smallest element from the same list containing the polled element 
		 * 3. Repeat till we have gone through all elements, ie till minHeap.isEmpty()
		 */
		ListNode dummyHead = new ListNode(-1);
		ListNode tempdummyHead = dummyHead;
		ListNode currNode;
		while (!minHeap.isEmpty()) {
			currNode = minHeap.poll();
			tempdummyHead.next = currNode;
			tempdummyHead = currNode;
			
			if(currNode!=null && currNode.next!=null) {
				currNode = currNode.next;
				minHeap.offer(currNode);
			}
		}
		return dummyHead.next;
	}
	

}

class Element {
	public int row, col, val;

	Element(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

