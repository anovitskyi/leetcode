class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode result = reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return result;
    }
}