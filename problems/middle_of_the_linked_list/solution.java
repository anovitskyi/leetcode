class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fictiveHead = new ListNode(0, head);
        ListNode fast = fictiveHead;
        ListNode slow = fictiveHead;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return slow;
    } 
}