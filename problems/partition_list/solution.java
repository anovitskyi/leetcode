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
        ListNode result = new ListNode();
        ListNode smaller = result;
        ListNode greaterHead = new ListNode();
        ListNode greater = greaterHead;
        
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            
            head = head.next;
        }
        
        greater.next = null;
        smaller.next = greaterHead.next;
        return result.next;
    }
}