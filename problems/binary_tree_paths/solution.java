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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        
        if (root != null) {
            backtrack(result, root.val + "", root);
        }

        return result;
    }

    private void backtrack(List<String> result, String curr, TreeNode node) {
        if (node.left == null && node.right == null) {
            result.add(curr);
            return;
        }

        if (node.left != null) {
            backtrack(result, curr + "->" + node.left.val, node.left);
        }

        if (node.right != null) {
            backtrack(result, curr + "->" + node.right.val, node.right);
        }
    }
}