package hard;

import java.util.PriorityQueue;
import java.util.Queue;

import requiredClassesForSome.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Id23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((l1,l2)->l1.val-l2.val);
        
        for(ListNode list: lists){
            if(list!=null)minHeap.offer(list);
        }
        
        ListNode mergedListPlaceholder = new ListNode(0);
        ListNode mergedList = mergedListPlaceholder;
        ListNode curr;
        while(!minHeap.isEmpty()){
            curr=minHeap.poll();
            mergedList.next=curr;
            mergedList=curr;
            
            if(curr!=null && curr.next!=null)minHeap.offer(curr.next);
        }
        
        return mergedListPlaceholder.next;
        
    }
}