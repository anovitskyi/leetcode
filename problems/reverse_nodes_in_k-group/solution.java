class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        
        int size = getSize(head);
        ListNode fictiveHead = new ListNode();
        ListNode tmp = fictiveHead;

        for (int i = 0; i < size / k; ++i) {
           tmp.next = reverse(head, k);
           tmp = head;
           head = head.next;
        }
        tmp.next = head;

        return fictiveHead.next;
    }

    private ListNode reverse(ListNode curr, int k) {
        if (k == 1) {
            return curr;
        }

        ListNode head = reverse(curr.next, k - 1);
        ListNode tmp = curr.next;
        curr.next = curr.next.next;
        tmp.next = curr;
        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            ++size;
            head = head.next;
        }
        return size;
    }
}