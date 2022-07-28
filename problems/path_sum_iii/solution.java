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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        return findPath(root, targetSum - root.val) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int findPath(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        
        int left = 0;
        if (root.left != null) {
            left = findPath(root.left, targetSum - root.left.val);
        }
        
        int right = 0;
        if (root.right != null) {
            right = findPath(root.right, targetSum - root.right.val);
        }
        
        return left + right + (targetSum == 0 ? 1 : 0);
    }
}