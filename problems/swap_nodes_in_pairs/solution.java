class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fictiveHead = new ListNode(0, head);
        ListNode pointer = fictiveHead;
        
        while (pointer.next != null && pointer.next.next != null) {
            ListNode first = pointer.next;
            ListNode second = pointer.next.next;
            first.next = second.next;
            second.next = first;
            pointer.next = second;
            
            pointer = first;
        }
        
        return fictiveHead.next;
    }
}