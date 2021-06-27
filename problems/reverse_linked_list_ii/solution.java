class Solution {
    public ListNode reverseBetween(ListNode node, int left, int right) {
        ListNode head = new ListNode();
        head.next = node;
        ListNode pointer = head;
        int counter = right - left;
        
        while (left-- > 1) {
            pointer = pointer.next;
        }
        
        pointer.next = reverse(pointer.next, counter);
        
        return head.next;
    }
    
    private ListNode reverse(ListNode node, int counter) {
        if (counter == 0) {
            return node;
        }
        
        ListNode head = reverse(node.next, counter - 1);
        ListNode next = node.next;
        node.next = next.next;
        next.next = node;
        return head;
    }
}