class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fictionHead = new ListNode(0, head);
        ListNode first = fictionHead;
        ListNode second = fictionHead;
        
        while (n-- > 0) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        
        return fictionHead.next;
    }
}