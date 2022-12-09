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
    public int maxAncestorDiff(TreeNode root) {
        int[] result = new int[1];
        traverse(root, result, root.val, root.val);
        return result[0];
    }

    private void traverse(TreeNode node, int[] result, int max, int min) {
        if (node == null) {
            return;
        }

        int newMax = Math.max(max, node.val);
        int newMin = Math.min(min, node.val);
        result[0] = Math.max(result[0], newMax - newMin);

        traverse(node.left, result, newMax, newMin);
        traverse(node.right, result, newMax, newMin);
    }
}