class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int tmp = head.val;
        head.val = head.next.val;
        head.next.val = tmp;
        
        swapPairs(head.next.next);
        return head;
    }
}