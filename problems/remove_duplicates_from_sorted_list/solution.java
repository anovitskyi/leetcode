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
        if (head == null) {
            return null;
        }
        
        ListNode current = head;
        
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
    
}