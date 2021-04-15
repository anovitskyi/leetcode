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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
    
        ListNode fictiveLeft = left;
        ListNode fictiveRight = right;
    
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            head = head.next;
            
            if (tmp.val < x) {
                left.next = tmp;
                left = tmp;
            } else {
                right.next = tmp;
                right = tmp;
            }
        }
    
        left.next = fictiveRight.next;
        return fictiveLeft.next;
    }
}

// [1,4,3,2,5,2]
// 3