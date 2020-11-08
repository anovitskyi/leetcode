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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        
        int left = 0;
        if (root.left != null) {
            result += findTilt(root.left);
            left = root.left.val;
        }
        
        int right = 0;
        if (root.right != null) {
            result += findTilt(root.right);
            right = root.right.val;
        }
        
        root.val += left + right;
        return result + Math.abs(left - right);
    }
}