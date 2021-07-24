class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        long result = Long.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.val > root.val && node.val < result) {
                    result = node.val;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        
        return result == Long.MAX_VALUE ? -1 : (int) result;
    }
}