class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while (--size >= 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        
        
        return result;
    }
    
    
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         dfs(root, result, 0);
//         return result;
//     }
    
//     private void dfs(TreeNode node, List<List<Integer>> result, int level) {
//         if (node == null) {
//             return;
//         }
        
//         List<Integer> list = null;
//         if (level < result.size()) {
//             list = result.get(level);
//         } else {
//             list = new LinkedList<>();
//             result.add(list);
//         }
        
//         list.add(node.val);
//         dfs(node.left, result, level + 1);
//         dfs(node.right, result, level + 1);
//     }
}