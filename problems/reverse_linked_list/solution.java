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
    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        
        ListNode root = reverseList(node.next);
        
        ListNode tmp = node.next;
        node.next = tmp.next;
        tmp.next = node;
        
        return root;
    }
}