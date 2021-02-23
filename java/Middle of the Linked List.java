class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null)
            return head;
        
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;
        while(fast_ptr != null && fast_ptr.next!= null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        
        return slow_ptr;
        
    }
}