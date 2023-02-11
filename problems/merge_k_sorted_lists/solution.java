class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode tmp = head;

        while (true) {
            int nullLists = 0;
            int minValue = Integer.MAX_VALUE;
            int minIndex = Integer.MAX_VALUE;

            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    ++nullLists;
                } else if (lists[i].val < minValue) {
                    minIndex = i;
                    minValue = lists[i].val;
                }
            }

            if (nullLists == lists.length) {
                break;
            }

            tmp.next = lists[minIndex];
            tmp = tmp.next;
            lists[minIndex] = lists[minIndex].next;
        }
        tmp.next = null;

        return head.next;
    }
}