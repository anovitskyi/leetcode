/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getListSize(headA);
        int sizeB = getListSize(headB);
        
        while (sizeA > sizeB) {
            --sizeA;
            headA = headA.next;
        }
        
        while (sizeB > sizeA) {
            --sizeB;
            headB = headB.next;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private int getListSize(ListNode head) {
        ListNode tmp = head;
        int size = 0;
        while (head != null) {
            ++size;
            head = head.next;
        }
        return size;
    }
}