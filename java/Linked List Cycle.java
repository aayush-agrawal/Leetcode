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
    public boolean hasCycle(ListNode head) {
        
        if(head == null)
            return false;
        
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;
        
        while(slow_ptr!= null && fast_ptr!=null && fast_ptr.next!= null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            
            if(slow_ptr == fast_ptr)
                return true;
        }
        
        return false;
    }
}