package easy;

import java.util.ArrayList;
import java.util.List;

import requiredClassesForSome.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Id234 {
	
	//O(1) space
	public boolean isPalindrome1(ListNode head) {
        //Edge input
        if(head.next==null)return true;
        
        ListNode fast = head;
        ListNode slow = head;
        boolean oddLength = false;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast!=null){
            oddLength = true;
        }
        
        //Fast points to start of originalLL. 
        //Slow points to start of reverseLL. Ie points to end of originallLL till midpt.
        fast = head;
        if(oddLength){
            slow = reverseLL(slow.next);//To ignore the middle node if odd
        }
        else{
            slow = reverseLL(slow);
        }
        
        //Iterate from front and back of original LL
        while(fast!=null && slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        
        return true;
        
    }
    
	//O(n) space
	public boolean isPalindrome2(ListNode head) {
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
	
	private ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        
        while(curr!=null){
            next = curr.next;
            
            //Reverse link -> update last seen node ie prev -> traverse LL
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}