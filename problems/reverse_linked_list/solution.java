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
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         while (head != null) {
//             ListNode tmp = head.next;
//             head.next = prev;
//             prev = head;
//             head = tmp;
//         }
        
//         return prev;
//     }
    
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
        
//         ListNode h = reverseList(head.next);
//         ListNode tmp = head.next;
//         head.next = tmp.next;
//         tmp.next = head;
//         return h;
//     }
    
    public ListNode reverseList(ListNode root) {  // 1
        if(root == null) {
            return null;
        }

        return dfs(null, root); // 1
    }

        private ListNode dfs(ListNode parent, ListNode n) { // null 1;  
            ListNode res = null;
                    if(n.next != null) {
                        res = dfs(n, n.next); // 5 4 3 2 
                } else { // 
                    n.next = parent;
                    return n;
                }

                n.next = parent;
                return res;


        }

}