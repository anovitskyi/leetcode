class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fictiveHead = new ListNode(0);
        ListNode head = fictiveHead;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            l2 = l2.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return fictiveHead.next;
    }
}