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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int left = 0;
        if (root.left != null) {
            if (!isBalanced(root.left)) {
                return false;
            }
            left = root.left.val;
        }
        
        int right = 0;
        if (root.right != null) {
            if (!isBalanced(root.right)) {
                return false;
            }
            right = root.right.val;
        }
        
        root.val = Math.max(left, right) + 1;
        
        return Math.abs(left - right) < 2;
    }
}