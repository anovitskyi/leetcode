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
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<Iterator<Node>> stack = new Stack<>();
        stack.push(List.of(root).iterator());
        
        while (!stack.isEmpty()) {
            Iterator<Node> currIter = stack.peek();
            if (!currIter.hasNext()) {
                stack.pop();
                continue;
            }
            
            Node currNode = currIter.next();
            result.add(currNode.val);
            
            if (currNode.children != null) {
                stack.push(currNode.children.iterator());
            }
        }
        
        return result;
    }
}