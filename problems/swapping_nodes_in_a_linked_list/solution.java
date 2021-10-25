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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode before = null;
        ListNode after = null;
        
        ListNode fast = head;
        ListNode slow = head;
        while (--k > 0) {
            fast = fast.next;
        }
        
        before = fast;
        
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        after = slow;
        
        int tmp = before.val;
        before.val = after.val;
        after.val = tmp;
        
        return head;
    }
}