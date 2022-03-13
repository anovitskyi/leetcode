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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode fictiveHead = new ListNode();
        ListNode tmp = fictiveHead;
        
        while (true) {
            ListNode min = null;
            int minIndex = -1;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    continue;
                }
                
                if (min == null || min.val > lists[i].val) {
                    min = lists[i];
                    minIndex = i;
                } 
            }
            
            if (min == null) {
                break;
            }
            
            lists[minIndex] = lists[minIndex].next;
            tmp.next = min;
            tmp = tmp.next;
        }
        
        tmp.next = null;
        
        return fictiveHead.next;
    }
}