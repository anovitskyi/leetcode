class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();

        for (String product : products) {
            Node node = root;
            
            for (int i = 0; i < product.length(); ++i) {
                char ch = product.charAt(i);
                node = node.children.computeIfAbsent(ch, x -> new Node());
                node.words.offer(product);
            }
        }

        List<List<String>> result = new ArrayList<>();
    
        for (int i = 0; i < searchWord.length(); ++i) {
            char ch = searchWord.charAt(i);
            root = root.children.computeIfAbsent(ch, x -> new Node());

            List<String> level = new ArrayList<>(3);
            for (int j = 0; j < 3 && !root.words.isEmpty(); ++j) {
                level.add(root.words.poll());
            }
            result.add(level);
        }

        return result;
    }

    private static class Node {
        final Queue<String> words = new PriorityQueue<>();
        final Map<Character, Node> children = new HashMap<>();
    }
}