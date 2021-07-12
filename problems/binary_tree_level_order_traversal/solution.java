class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new LinkedList<>();
//         Queue<TreeNode> queue = new LinkedList<>();
//         if (root != null) {
//             queue.offer(root);
//         }
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<Integer> list = new LinkedList<>();
//             while (size-- > 0) {
//                 TreeNode node = queue.poll();
//                 list.add(node.val);
                
//                 if (node.left != null) {
//                     queue.offer(node.left);
//                 }
                
//                 if (node.right != null) {
//                     queue.offer(node.right);
//                 }
//             }
//             result.add(list);
//         }
        
//         return result;
//     }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, 0, root); 
        return result;
    }
    
    private void traverse(List<List<Integer>> result, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        
        List<Integer> list = result.get(level);
        list.add(node.val);
        traverse(result, level + 1, node.left);
        traverse(result, level + 1, node.right);
    }
}