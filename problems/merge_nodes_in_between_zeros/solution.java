class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode curr = result;
        
        int elem = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                curr.next = new ListNode(elem);
                curr = curr.next;
                elem = 0;
            } else {
                elem += head.val;
            }
            
            head = head.next;
        }
        
        return result.next;
    }
}