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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode start = new ListNode(Integer.MIN_VALUE);
    
        while (head != null) {
            ListNode curr = start;
            while (curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }
            
            ListNode headNext = head.next;
            ListNode currNext = curr.next;
            curr.next = head;
            curr.next.next = currNext;
            head = headNext;
        }
        
        return start.next;
    }
}