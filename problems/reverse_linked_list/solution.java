class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return head;
        }
        
        ListNode prev = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return prev;
    }
    
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
        
//         ListNode result = null;
//         while (head != null) {
//             ListNode tmp = result;
//             result = head;
//             head = head.next;
//             result.next = tmp;
//         }
        
//         return result;
//     }

}