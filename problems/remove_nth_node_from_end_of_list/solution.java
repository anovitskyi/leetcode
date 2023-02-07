class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fictive = new ListNode(0, head);
        ListNode fast = fictive;
        ListNode slow = fictive;

        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return fictive.next;
    }
}