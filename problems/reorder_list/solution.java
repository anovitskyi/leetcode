class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode stackHead = head;
        while (stackHead != null) {
            stack.push(stackHead);
            stackHead = stackHead.next;
        }
        int size = stack.size();

        ListNode copy = head;
        for (int i = 0; i < size / 2; ++i) {
            ListNode tmp = copy.next;
            copy.next = stack.pop();
            copy = copy.next;
            copy.next = tmp;
            copy = copy.next;
        }

        copy.next = null;
    }
}