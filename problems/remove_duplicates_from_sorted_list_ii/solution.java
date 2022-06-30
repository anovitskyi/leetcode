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

/*
              |
    1 -> 1 -> 1
               |             
    curr = -1000

*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {   
        ListNode result = new ListNode(-10000, head);
        ListNode curr = result;
        
        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                curr = curr.next;
                head = head.next;
                continue;
            }
            
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            curr.next = head.next;
            head = head.next;
        }
        
        return result.next;
    }
}