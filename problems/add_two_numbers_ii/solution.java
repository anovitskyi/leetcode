class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Size = getSize(l1);
        int l2Size = getSize(l2);
    
        ListNode result = divideAndConquer(l1, l1Size, l2, l2Size);
        int carry = truncateResult(result);
        if (carry != 0) {
            return new ListNode(carry, result);
        }
        return result;
    }
    
    private ListNode divideAndConquer(ListNode l1, int l1Size, ListNode l2, int l2Size) {
        if (l1Size == 1 && l2Size == 1) {
            return new ListNode(l1.val + l2.val);
        }
        
        ListNode result = null;
        int left = 0;
        int right = 0;
        if (l1Size > l2Size) {
            result = divideAndConquer(l1.next, l1Size - 1, l2, l2Size);
            left = l1.val;
        } else if (l2Size > l1Size) {
            result = divideAndConquer(l1, l1Size, l2.next, l2Size - 1);
            right = l2.val;
        } else {
            result = divideAndConquer(l1.next, l1Size - 1, l2.next, l2Size - 1);
            left = l1.val;
            right = l2.val;
        }
        
        int carry = truncateResult(result);
        return new ListNode(left + right + carry, result);
    }
    
    private int truncateResult(ListNode result) {
        int carry = 0;
        if (result.val > 9) {
            carry = result.val / 10;
            result.val = result.val % 10;
        }
        return carry;
    }
    
    private int getSize(ListNode list) {
        int size = 0;
        while (list != null) {
            list = list.next;
            ++size;
        }
        return size;
    }
}