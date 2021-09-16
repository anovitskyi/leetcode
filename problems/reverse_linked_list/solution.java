class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode last = reverseList(head.next);
        ListNode next = head.next.next;
        head.next.next = head;
        head.next = next;
        return last;
    }
}