class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int size = getListSize(head);
        return sort(head, size);
    }
    
    private ListNode sort(ListNode head, int size) {
        if (size == 1) {
            return head;
        }
        
        int mid = size / 2;
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < mid; ++i) {
            right = right.next;
        }
        
        left = sort(left, mid);
        right = sort(right, size - mid);
        return merge(left, mid, right, size - mid);
    }
    
    private ListNode merge(ListNode left, int leftSize, ListNode right, int rightSize) {
        ListNode result = new ListNode();
        ListNode curr = result;
        
        while (leftSize > 0 && rightSize > 0) {
            if (left.val < right.val) {
                curr.next = left;
                --leftSize;
                left = left.next;
            } else {
                curr.next = right;
                --rightSize;
                right = right.next;
            }
            
            curr = curr.next;
        }
        
        while (leftSize-- > 0) {
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }
        
        curr.next = right;
        return result.next;
    }
    
    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            ++size;
        }
        return size;
    }
}