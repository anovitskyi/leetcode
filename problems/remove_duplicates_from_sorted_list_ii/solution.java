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
        ListNode fictiveHead = new ListNode(0, head);
        ListNode curr = fictiveHead;
        
        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                curr = curr.next;
                head = head.next;
                continue;
            } 
            
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            curr.next = head.next;
            head = head.next;
        }
        
        return fictiveHead.next;
    }
}