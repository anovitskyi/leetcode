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
        Queue<Integer> queue = new PriorityQueue<>();
        
        while (true) {
            int added = 0;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null) {
                    ++added;
                    queue.offer(lists[i].val);
                    lists[i] = lists[i].next;
                }
            }
            if (added == 0) {
                break;
            }
        }
        
        ListNode result = new ListNode();
        ListNode tmp = result;
        while (!queue.isEmpty()) {
            tmp.next = new ListNode(queue.poll());
            tmp = tmp.next;
        }
        
        return result.next;
    }
}