class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> result = new LinkedList<>();
//         if (root == null) {
//             return result;
//         }
        
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<Integer> list = new LinkedList<>();
            
//             while (--size >= 0) {
//                 Node node = queue.poll();
//                 list.add(node.val);
                
//                 for (Node n : node.children) {
//                     if (n != null) {
//                         queue.add(n);
//                     }
//                 }
//             }
            
//             result.add(list);
//         }
        
//         return result;
//     }
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root == null ? null : Collections.singletonList(root), 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Node> nodes, int level) {
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        
        List<Integer> list = null;
        if (level < result.size()) {
            list = result.get(level);
        } else {
            list = new LinkedList<>();
            result.add(list);
        }
        
        for (Node node : nodes) {
            list.add(node.val);
            dfs(result, node.children, level + 1);
        }
    }
}