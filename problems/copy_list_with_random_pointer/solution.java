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
        Map<Node, Node> map = new HashMap<>();

        Node fictiveHead = new Node(-1);

        Node newHead = fictiveHead;
        Node prevHead = head;
        while (prevHead != null) {
            Node tmp = new Node(prevHead.val);
            map.put(prevHead, tmp);

            newHead.next = tmp;
            newHead = newHead.next;

            prevHead = prevHead.next;
        }

        Node randomHead = fictiveHead.next;
        Node prevRandomHead = head;
        while (prevRandomHead != null) {
            randomHead.random = map.get(prevRandomHead.random);

            randomHead = randomHead.next;
            prevRandomHead = prevRandomHead.next;
        }

        return fictiveHead.next;
    }
}