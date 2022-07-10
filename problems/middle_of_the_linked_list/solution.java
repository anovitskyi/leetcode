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
    public ListNode middleNode(ListNode head) {
        int middle = getListSize(head) / 2;
        while (middle > 0) {
            head = head.next;
            --middle;
        }
        
        return head;
    }
    
    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            ++size;
        }
        return size;
    }
}