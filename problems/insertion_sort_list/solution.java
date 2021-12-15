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
        ListNode result = new ListNode();
        while (head != null) {
            ListNode tmp = result;
            while (tmp.next != null && tmp.next.val < head.val) {
                tmp = tmp.next;
            }
            ListNode curr = head;
            head = head.next;
            curr.next = tmp.next;
            tmp.next = curr;
        }
        return result.next;
    }
}