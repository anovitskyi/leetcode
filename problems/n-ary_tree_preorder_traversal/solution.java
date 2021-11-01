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
        return traverseIteratively(root, new LinkedList<>());
    }
    
    private List<Integer> traverseIteratively(Node node, List<Integer> result) {
        Stack<Node> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }
        
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            result.add(top.val);
            
            List<Node> children = top.children;
            for (int i = children.size() - 1; i >= 0; --i) {
                Node child = children.get(i);
                if (child != null) {
                    stack.push(child);   
                }
            }
        }
        
        return result;
    }
    
    private List<Integer> traverseRecursively(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            for (Node child : node.children) {
                traverseRecursively(child, result);
            }
        }
        return result;
    }
}