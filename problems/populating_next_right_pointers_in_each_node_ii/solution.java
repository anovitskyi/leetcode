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
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = null;
            while (--size >= 0) {
                Node tmp = queue.poll();
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                
                tmp.next = last;
                last = tmp;
            }
            
        }
        return root;
    }
}