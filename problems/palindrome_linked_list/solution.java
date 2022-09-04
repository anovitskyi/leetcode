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
    public boolean isPalindrome(ListNode head) {
        int size = getSize(head);
        
        ListNode prev = null;
        for (int i = 0; i < size / 2; ++i) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        if (size % 2 == 1) {
            head = head.next;
        }
        
        while (head != null) {
            if (head.val != prev.val) {
                return false;
            }
            
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            ++size;
        }
        return size;
    }
}