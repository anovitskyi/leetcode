/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node fictiveHead = new Node(-1);
        Node tmp = fictiveHead;
        
        Map<Node, Node> map = new HashMap<>();
        
        while (head != null) {
            Node next = new Node(head.val);
            next.random = head.random;
            map.put(head, next);
            tmp.next = next;
            tmp = next;
            head = head.next;
        }
        
        tmp = fictiveHead.next;
        while (tmp != null) {
            tmp.random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return fictiveHead.next;
    }
}