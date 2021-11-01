class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        int size = getListSize(head);
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < size / 2; ++i) { // 0
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if (size % 2 == 1) {
            curr = curr.next;
        }
        
        while (curr != null) {
            if (curr.val != prev.val) {
                return false;
            }
            curr = curr.next;
            prev = prev.next;
        }
        
        return true;
    }
    
    private int getListSize(ListNode node) {
        int size = 0;
        while (node != null) {
            ++size;
            node = node.next;
        }
        return size;
    }
}