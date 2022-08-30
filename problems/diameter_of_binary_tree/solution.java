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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxChildrenDiameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        
        int leftLength = 0;
        if (root.left != null) {
            leftLength = root.left.val + 1;
        }
        
        int rightLength = 0;
        if (root.right != null) {
            rightLength = root.right.val + 1;
        }
        
        root.val = Math.max(leftLength, rightLength);
        
        return Math.max(leftLength + rightLength, maxChildrenDiameter);
    }
}