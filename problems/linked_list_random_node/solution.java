class Solution {

    private ListNode head;
    private ListNode curr;
    
    public Solution(ListNode head) {
        this.head = head;
        this.curr = head;
    }
    
    public int getRandom() {
        int rand = (int) (Math.random() * 100) + 1;
        
        while (--rand >= 0) {
            if (curr.next == null) {
                curr.next = head;
            }
            
            curr = curr.next;
        }
        
        return curr.val;
    }
}
