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
    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        traverse(root, builder);
        return builder.toString();
    }
    
    private void traverse(TreeNode root, StringBuilder b) {
        if (root == null) {
            return;
        }
        
        b.append(root.val);
        
        if (root.left != null) {
            b.append("(");
            traverse(root.left, b);
            b.append(")");
        } 
        
        if (root.right != null) {
            if (root.left == null) {
                b.append("()");
            }
            b.append("(");
            traverse(root.right, b);
            b.append(")");
        }
    }
}