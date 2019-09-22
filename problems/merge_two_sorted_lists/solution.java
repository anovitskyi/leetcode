/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode root = null;
        ListNode current = null;
        
        while (l1 != null && l2 != null) {
            int val;
            if (l1.val <= l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            
            if (root == null) {
                current = new ListNode(val);
                root = current;
            } else {
                ListNode tmp = current;
                current = new ListNode(val);
                tmp.next = current;
            }
        }
        
        if (l1 == null) {
            current.next = l2;
        } else if (l2 == null) {
            current.next = l1;
        }
        
        return root;
    }
}