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
        Stack<Iterator<Node>> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        
        if (root != null) {
            stack.push(Arrays.asList(root).iterator());
        }
        
        while (!stack.isEmpty()) {
            Iterator<Node> peek = stack.peek();
            
            if (!peek.hasNext()) {
                stack.pop();
                continue;
            }
            
            Node nextNode = peek.next();
            if (nextNode.children != null && !nextNode.children.isEmpty()) {
                stack.push(nextNode.children.iterator());
            }
                           
            result.add(nextNode.val);
        }
        
        
        return result;
    }
}