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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        
        ListNode lTmp = left;
        ListNode rTmp = right;
        
        while (head != null) {
            ListNode node = new ListNode(head.val);
            
            if (node.val < x) {
                lTmp.next = node;
                lTmp = node;
            } else {
                rTmp.next = node;
                rTmp = node;
            }
            head = head.next;
        }
        
        lTmp.next = right.next;
        return left.next;
    }
}