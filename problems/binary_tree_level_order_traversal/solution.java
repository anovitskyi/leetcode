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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        preOrderTraversal(root, 0, result);
        return result;
    }
    
    private void preOrderTraversal(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        List<Integer> values = null;
        if (level >= result.size()) {
            values = new ArrayList<>();
            result.add(values);
        } else {
            values = result.get(level);
        }
        
        values.add(node.val);
        
        preOrderTraversal(node.left, level + 1, result);
        preOrderTraversal(node.right, level + 1, result);
    }
}