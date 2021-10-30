class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = getListSize(head);
        return sort(head, size);
    }
    
    private ListNode sort(ListNode head, int size) {
        if (size <= 1) {
            return head;
        }
        
        int mid = size / 2;
        ListNode left = sort(head, mid);
        
        ListNode right = head;
        for (int i = 0; i < mid; ++i) {
            right = right.next;
        }
        right = sort(right, size - mid);
        
        return merge(left, mid, right, size - mid);
    }
    
    private ListNode merge(ListNode left, int leftSize, ListNode right, int rightSize) {
        ListNode result = new ListNode();
        ListNode node = result;
        
        while (leftSize > 0 && rightSize > 0) {
            if (left.val < right.val) {
                node.next = new ListNode(left.val);
                left = left.next;
                --leftSize;
            } else {
                node.next = new ListNode(right.val);
                right = right.next;
                --rightSize;
            }
            node = node.next;
        } 
        
        while (leftSize-- > 0) {
            node.next = new ListNode(left.val);
            left = left.next;
            node = node.next;
        }
        
        while (rightSize-- > 0) {
            node.next = new ListNode(right.val);
            right = right.next;
            node = node.next;
        }
        
        return result.next;
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