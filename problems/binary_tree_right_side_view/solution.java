/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        return rightSideViewDFS(root);
    }
    
    public List<Integer> rightSideViewDFS(TreeNode root) {
        return dfs(root, new LinkedList<>(), 0);
    }
    
    private List<Integer> dfs(TreeNode node, List<Integer> result, int level) {
        if (node == null) {
            return result;
        }
        
        if (result.size() == level) {
            result.add(node.val);
        }
        
        dfs(node.right, result, level + 1);
        dfs(node.left, result, level + 1);
        
        return result;
    }
    
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            result.add(queue.peek().val);
            
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        
        return result;
    }
}