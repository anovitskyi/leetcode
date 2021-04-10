class Solution {
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            ++size;
            tmp = tmp.next;
        }
        
        for (int i = 0; i < size / 2; ++i) {
            ListNode prev = tmp;
            ListNode next = head.next;
            
            head.next = prev;
            tmp = head;
            head = next;
        }
        
        if (size % 2 == 1) {
            head = head.next;
        }
        
        while (head != null) {
            if (head.val != tmp.val) {
                return false;
            }
            
            tmp = tmp.next;
            head = head.next;
        }
        
        return true;
    }
}