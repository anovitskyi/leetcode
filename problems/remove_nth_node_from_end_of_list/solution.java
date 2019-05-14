/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode tmp = head;
        
        while (tmp != null) {
            tmp = tmp.next;
            ++size;
        }
        
        if (size == 1) {
            return null;
        } else if (size - n == 0) {
            return head.next;
        }
        
        tmp = head;
        for (int i = 1; i < size - n; ++i) {
            tmp = tmp.next;
        }
        
        tmp.next = tmp.next.next;
        
        return head;
    }
}