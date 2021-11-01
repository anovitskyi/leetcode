class Solution {
    
    public ListNode reverseList(ListNode head) {
        return reverseListRecursive(head);
    }
    
    private ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode root = reverseListRecursive(head.next);
        ListNode tmp = head.next.next;
        head.next.next = head;
        head.next = tmp;
        return root;
    }
}