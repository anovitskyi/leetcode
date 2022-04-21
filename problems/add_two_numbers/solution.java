/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode curr = result;
        int carrying = 0;
        
        while (l1 != null || l2 != null) {
            int l1val = 0;
            if (l1 != null) {
                l1val = l1.val;
                l1 = l1.next;
            }
            
            int l2val = 0;
            if (l2 != null) {
                l2val = l2.val;
                l2 = l2.next;
            }
            
            int val = l1val + l2val + carrying;
            carrying = val / 10;
            ListNode tmp = new ListNode(val % 10);
            curr.next = tmp;
            curr = tmp;
        }
        
        if (carrying != 0) {
            curr.next = new ListNode(carrying);
        }
        
        return result.next;
    }
}