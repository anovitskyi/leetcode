/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        
        list.add(root.val);
        for (Node child : root.children) {
            list.addAll(preorder(child));
        }
        
        return list;
    }
    
    private void recursion(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        list.add(node.val);
        for (Node child : node.children) {
            recursion(child, list);
        }
    }
}