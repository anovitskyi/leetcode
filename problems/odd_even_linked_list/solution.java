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
        ListNode oddHead = new ListNode();
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode();
        ListNode even = evenHead;
        
        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                odd.next = head;
                odd = head;
            } else {
                even.next = head;
                even = head;
            }
            
            head = head.next;
            ++index;
        }
        
        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
    }
}