/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        if (current == null) {
            return head;
        }
        
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;   
            }
        }
        return head;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode root = head;
        
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            } 
        }
        
        return root;
    }
}