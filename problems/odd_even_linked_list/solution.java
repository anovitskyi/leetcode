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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode oddHead = odd;
        ListNode evenHead = even;
        
        for (int i = 0; head != null; ++i, head = head.next) {
            if (i % 2 == 0) {
                odd.next = head;
                odd = head;
            } else {
                even.next = head;
                even = head;
            }
        }
        
        even.next = null;
        odd.next = evenHead.next;
        
        return oddHead.next;
    }
}