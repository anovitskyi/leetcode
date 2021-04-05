class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            while (size-- > 0) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(node.val);
        }
         
        return result;
    }
}