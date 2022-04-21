public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aSize = getListSize(headA);
        int bSize = getListSize(headB);
        
        while (aSize > bSize) {
            headA = headA.next;
            --aSize;
        }
        
        while (bSize > aSize) {
            headB = headB.next;
            --bSize;
        }
        
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    private int getListSize(ListNode node) {
        int size = 0;
        while (node != null) {
            ++size;
            node = node.next;
        }
        return size;
    }
}