package medium;

import requiredClassesForSome.ListNode;

import java.math.BigInteger;

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

//Take care of integer overflow by using long -> Nope too small -> BigInteger
//Take care of edge case where each node only refers to zero

//Probably the proper approach is to add the 2 nodes, then construct new node on fly
//But by doing that I need to think about carry and shit
class Id2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2.val==0 && l2.next==null && l1.val==0 && l1.next==null)return l2;
        
        l1 = reverseLL(l1);
        l2 = reverseLL(l2);
        
        BigInteger num1=concatenatedNum(l1);
        BigInteger num2=concatenatedNum(l2);        
        BigInteger numAdd=num1.add(num2);

        
        ListNode addList=new ListNode();
        ListNode dummy=addList;
        while(numAdd!=BigInteger.ZERO){
            dummy.next = new ListNode(numAdd.remainder(BigInteger.TEN).intValue());
            numAdd=numAdd.divide(BigInteger.TEN);
            dummy=dummy.next;
        }
        
        return addList.next;
    }
    
    private ListNode reverseLL(ListNode node){
        ListNode next=null, prev=null;
        
        while(node!=null){
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        
        return prev;
    }
    
    private BigInteger concatenatedNum(ListNode node){
        BigInteger num=BigInteger.ZERO;
        while(node!=null){
            num=num.multiply(BigInteger.TEN).add(BigInteger.valueOf((long)node.val));
            node=node.next;
        }
        return num;
    }
}