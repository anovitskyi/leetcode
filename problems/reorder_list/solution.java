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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = getStack(head);
        int numberOfOperations = stack.size() / 2;
        ListNode tmp = head;
    
        for (int i = 0; i < numberOfOperations; ++i) {
            ListNode next = tmp.next;
            ListNode stackNode = stack.pop();
            
            stackNode.next = next;
            tmp.next = stackNode;
            tmp = next;
        }
        
        tmp.next = null;
    }
    
    private Stack<ListNode> getStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }        
        return stack;
    }
}