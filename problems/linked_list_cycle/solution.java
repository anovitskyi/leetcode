/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        while (head != null) {
            if (head == head.next) {
                return true;
            } else {
                ListNode tmp = head;
                head = head.next;
                tmp.next = tmp;
            }
        }
        
        return false;
    }
}