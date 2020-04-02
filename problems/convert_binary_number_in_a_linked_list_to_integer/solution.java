/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode copy = head;
        int size = -1;
        
        while (copy != null) {
            ++size;
            copy = copy.next;
        }
        
        int res = 0;
        while (head != null) {
            res += Math.pow(2, size) * head.val;
            head = head.next;
            --size;
        }
        
        return res;
    }
}