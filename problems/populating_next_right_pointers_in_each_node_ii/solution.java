/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root != null) {
            List<Node> list = new ArrayList<>();
            list.add(root);
            connect(list);
        }
        return root;
    }
    
    private void connect(List<Node> list) {
        if (list.isEmpty()) {
            return;
        }
        
        List<Node> nextList = new ArrayList<>();
        
        Node prev = new Node();
        for (int i = 0; i < list.size(); ++i) {
            Node curr = list.get(i);
            
            if (curr.left != null) {
                nextList.add(curr.left);
            }
            
            if (curr.right != null) {
                nextList.add(curr.right);
            }
            
            prev.next = curr;
            prev = curr;
        }
        
        connect(nextList);
    }
}