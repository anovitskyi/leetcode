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
        List<Integer> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        
        if (list.size() <= level) {
            list.add(root.val);
        }
        
        traverse(root.right, list, level + 1);
        traverse(root.left, list, level + 1);
    }
}