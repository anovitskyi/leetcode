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
        
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        
        if (root.next != null && (root.left != null || root.right != null)) {
            Node tmp = root.next;
            while (tmp != null && tmp.left == null && tmp.right == null) {
                tmp = tmp.next;
            }
            
            if (tmp != null) {
                Node source = root.right != null ? root.right : root.left;
                Node target = tmp.left != null ? tmp.left : tmp.right;
                source.next = target; 
            }
        }
        
        connect(root.right);
        connect(root.left);
        
        return root;
    }
}