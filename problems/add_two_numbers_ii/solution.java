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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) {
            return l2;
        }
        
        if (l2 == null || l2.val == 0) {
            return l1;
        }
        
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        
        while (l1 != null) {
            first.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            second.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode root = null;
        int prev = 0;
        
        while (!first.empty() || !second.empty()) {
            int fValue = first.empty() ? 0 : first.pop();
            int sValue = second.empty() ? 0 : second.pop();
            int val = fValue + sValue + prev;
            prev = val / 10;
            ListNode node = new ListNode(val % 10);
            node.next = root;
            root = node;
        }
        
        if (prev != 0) {
            ListNode node = new ListNode(prev);
            node.next = root;
            root = node;
        }
        
        return root;
    }
}