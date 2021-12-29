class Solution {
    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        int middle = size / 2;
        
        while (middle-- > 0) {
            head = head.next;
        }
        return head;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            ++size;
        }
        return size;
    }
}