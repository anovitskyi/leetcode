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
    public int pairSum(ListNode head) {
        Stack<ListNode> stack = prepareStack(head);
        int halfASize = stack.size() / 2;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < halfASize; ++i) {
            result = Math.max(result, head.val + stack.pop().val);
            head = head.next;
        }
        return result;
    }
    
    private Stack<ListNode> prepareStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        return stack;
    }
}