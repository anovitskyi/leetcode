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
        ListNode oddCurr = odd;
        ListNode even = new ListNode();
        ListNode evenCurr = even;

        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                oddCurr.next = head;
                oddCurr = oddCurr.next;
            }  else {
                evenCurr.next = head;
                evenCurr = evenCurr.next;
            }

            head = head.next;
            ++index;
        }

        evenCurr.next = null;
        oddCurr.next = even.next;

        return odd.next;
    }

}