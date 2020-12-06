class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        connect(root.left, root.right);
        
        return root;
    }
    
    private void connect(Node left, Node right) {
        if (left == null) {
            return;
        }
        
        left.next = right;
        
        connect(left.left, left.right);
        connect(right.left, right.right);
        connect(left.right, right.left);
    }
}