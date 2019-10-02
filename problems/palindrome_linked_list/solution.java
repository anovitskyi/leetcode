/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        int size = 0;
        ListNode counter = head;
        while (counter != null) {
            ++size;
            counter = counter.next;
        }
        
        int[] arr = new int[size];
        int c = 0;
        while (head != null) {
            arr[c++] = head.val;
            head = head.next;
        }
        
        for (int i = 0; i < size / 2; ++i) {
            if (arr[i] != arr[size - 1 - i]) {
                return false;
            }
        }
        
        return true;
    }
}