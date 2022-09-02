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
        if (root == null) {
            return root;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
        }
        
        if (root.next != null && (root.left != null || root.right != null)) {
            Node source = root.right != null ? root.right : root.left;
            Node target = null;
            Node next = root.next;
            while (next != null) {
                if (next.left != null) {
                    target = next.left;
                    break;
                }
                
                if (next.right != null) {
                    target = next.right;
                    break;
                }
                
                next = next.next;
            }
            
            source.next = target;
        }
        
        connect(root.right);
        connect(root.left);
        return root;
    }
}