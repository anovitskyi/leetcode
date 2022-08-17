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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode();
        ListNode curr = result;
        
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
                continue;
            }
            
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        
        curr.next = null;
        return result.next;
    }
}