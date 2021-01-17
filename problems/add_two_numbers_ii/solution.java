class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
        Stack<Integer> first = convertToStack(l1);
        Stack<Integer> second = convertToStack(l2);
        
        ListNode prev = null;
        int carrying = 0;
        while (!first.isEmpty() || !second.isEmpty()) {
            int sum = carrying;
            if (!first.isEmpty()) {
                sum += first.pop();
            }
            
            if (!second.isEmpty()) {
                sum += second.pop();
            }
            
            carrying = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = prev;
            prev = tmp;
        }
        
        if (carrying != 0) {
            ListNode tmp = new ListNode(carrying);
            tmp.next = prev;
            prev = tmp;
        }
        
        return prev;
    }
    
    private Stack<Integer> convertToStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
    
    
}