/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
     
        if(head == null)
            return head;
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        boolean isCycle = false;
        while(slowPtr!=null && fastPtr!=null && fastPtr.next!=null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if(slowPtr == fastPtr) {
                isCycle = true;
                break;
            }
        }
        
        if(!isCycle)
            return null;
        
        slowPtr = head;
        while(slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        
        return slowPtr;
    }
}