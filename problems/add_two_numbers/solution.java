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
        ListNode root = new ListNode();
        ListNode current = root;
        int carrying = 0;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carrying;
            carrying = sum / 10;
            sum = sum % 10;
            
            ListNode tmp = new ListNode(sum);
            current.next = tmp;
            current = tmp;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }
        
        
        while (carrying != 0) {
            if (current.next == null) {
                current.next = new ListNode(carrying);
                carrying = 0;
            } else {
                int sum = current.next.val + carrying;
                carrying = sum / 10;
                current.next.val = sum % 10;
                current = current.next;
            }
        }
        
        
        return root.next;
    }
}