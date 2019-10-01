/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        if (l2.val < l1.val) {
            ListNode tmp = l1;
            l1 = new ListNode(l2.val);
            l1.next = tmp;
            l2 = l2.next;
        }
        ListNode root = l1;
        
        while (l1.next != null) {
            if (l2 == null) {
                break;
            }
            if (l2.val < l1.next.val) {
                ListNode tmp = l1.next;
                l1.next = new ListNode(l2.val);
                l1.next.next = tmp;
                l2 = l2.next;
            }
            l1 = l1.next;
        }
        
        if (l2 != null) {
            l1.next = l2;
        }
        
        
        return root;
    }
    
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        int val;
        if (l1.val < l2.val) {
            val = l1.val;
            l1 = l1.next;
        } else {
            val = l2.val;
            l2 = l2.next;
        }
        ListNode current = new ListNode(val);
        ListNode root = current;
        
        while (true) {
            if (l1 == null || l2 == null) {
                break;
            } else if (l1.val < l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            
            ListNode tmp = current;
            current = new ListNode(val);
            tmp.next = current;
        }
        
        if (l1 == null) {
            current.next = l2;   
        } else if (l2 == null) {
            current.next = l1;
        }
        
        return root;
    }
}