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
    public int getDecimalValue(ListNode head) {
        ListNode sizeNode = head;
        int size = 0;
        while (sizeNode != null) {
            ++size;
            sizeNode = sizeNode.next;
        }
        
        int res = 0;
        while (head != null) {
            res += ((int) Math.pow(2, --size)) * head.val;
            head = head.next;
        }
        return res;
    }
}