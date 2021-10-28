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
        if (head == null || head.next == null) {
            return true;
        }
        
        int size = getListSize(head);
        ListNode node = head.next;
        ListNode prev = head;
        for (int i = 0; i < size / 2 - 1; ++i) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        
        if (size % 2 == 1) {
            node = node.next;
        }
        
        while (node != null) {
            if (node.val != prev.val) {
                return false;
            }
            node = node.next;
            prev = prev.next;
        }
        return true;
        
    }
    
    private int getListSize(ListNode node) {
        int size = 0;
        while (node != null) {
            ++size;
            node = node.next;
        }
        return size;
    }
}