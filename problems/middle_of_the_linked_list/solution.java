/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
//         int size = 0;
//         ListNode counter = head;
//         while (counter != null) {
//             ++size;
//             counter = counter.next;
//         }
        
//         for (int i = 0; i < size / 2; ++i) {
//             head = head.next;
//         }
        
//         return head;
        ListNode[] arr = new ListNode[100];
        int i = 0;
        while (head != null) {
            arr[i] = head;
            head = head.next;
            ++i;
        }
        
        return arr[i / 2];
    }
}