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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode tmpLeft = root.left;
        TreeNode tmpRight = root.right;
        
        if (root.left != null) {
            root.left = null;
            root.right = tmpLeft;
            flatten(tmpLeft);
            while (root.right != null) {
                root = root.right;
            }
        }
        
        flatten(tmpRight);
        root.right = tmpRight;
    }
}