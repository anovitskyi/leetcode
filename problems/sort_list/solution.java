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
    public ListNode sortList(ListNode head) {
        return mergeSort(head, getSize(head));
    }
    
    private ListNode mergeSort(ListNode head, int size) {
        if (size <= 1) {
            return head;
        }
        
        int mid = size / 2;
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < mid; ++i) {
            right = right.next;
        }
        
        left = mergeSort(left, mid);
        right = mergeSort(right, size - mid);
        
        ListNode result = new ListNode();
        ListNode curr = result;
        int leftSize = mid;
        int rightSize = size - mid;
        while (leftSize > 0 && rightSize > 0) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
                --leftSize;
            } else {
                curr.next = right;
                right = right.next;
                --rightSize;
            }
            
            curr = curr.next;
        }
        
        while (leftSize > 0) {
            curr.next = left;
            left = left.next;
            --leftSize;
            curr = curr.next;
        }

        curr.next = right;
        return result.next;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            ++size;
            head = head.next;
        }
        return size;
    }
}