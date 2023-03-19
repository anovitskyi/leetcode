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
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        return clone(new HashMap<>(), node);
    }

    private Node clone(Map<Integer, Node> map, Node source) {
        if (map.containsKey(source.val)) {
            return map.get(source.val);
        }

        Node newNode = new Node(source.val);
        map.put(source.val, newNode);

        for (Node neighbour : source.neighbors) {
            newNode.neighbors.add(clone(map, neighbour));
        }

        return newNode;
    }
}