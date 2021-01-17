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

// 9 9 9 9 9
// 9 9 9
// 8 9 9 0 0 1
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { // O(n + m)
        ListNode root = new ListNode();
        ListNode current = root;
        int carrying = 0;
        
        while (l1 != null || l2 != null) {
            int sum = carrying;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carrying = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            current.next = tmp;
            current = tmp;
        }
        
        if (carrying != 0) {
            current.next = new ListNode(carrying);
        }
        
        return root.next;
    }
}