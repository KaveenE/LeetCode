package medium;

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
class Id1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode nodeAtKFromFront=null, nodeAtKFromBack=null;
        int pos1Idxed=1;
        
        ListNode dummy=head;
        int len=length(head);
        while(dummy!=null){
            if(pos1Idxed==k){
                nodeAtKFromFront=dummy;
            }
            if(pos1Idxed==len-k+1){
                nodeAtKFromBack=dummy;
            }
            
            pos1Idxed++;
            dummy=dummy.next;
        }
        
        int temp=nodeAtKFromFront.val;
        nodeAtKFromFront.val=nodeAtKFromBack.val;
        nodeAtKFromBack.val=temp;
        
        return head;
    }
    
    private int length(ListNode node){
        int len=0;
        ListNode dummy=node;
        while(dummy!=null){
            len++;
            dummy=dummy.next;
        }
        return len;
    }
    
}