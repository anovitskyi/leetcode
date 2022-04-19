class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            
            while (size-- > 0) {
                TreeNode node = queue.poll();
                
                if (leftToRight) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                } 
            }
            
            result.add(level);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}