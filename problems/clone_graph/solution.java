/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private final Map<Integer, Node> graph = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        if (graph.containsKey(node.val)) {
            return graph.get(node.val);
        }

        Node copy = new Node(node.val);
        graph.put(copy.val, copy);

        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbour));
        }

        return copy;
    }
}