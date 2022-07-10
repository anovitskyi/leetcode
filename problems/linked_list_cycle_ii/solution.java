public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cycle = findCycle(head);
        if (cycle == null) {
            return null;
        }
        
        while (head != cycle) {
            head = head.next;
            cycle = cycle.next;
        }
        
        return head;
    }
    
    private ListNode findCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                return fast;
            }
        }
        
        return null;
    }
}