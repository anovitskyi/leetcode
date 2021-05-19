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
    public int sumEvenGrandparent(TreeNode root) {
        int val = 0;
        if (root == null) {
            return val;
        }
        
        if (root.val % 2 == 0) {
            val += getValues(root);
        }
        
        if (root.left != null) {
            val += sumEvenGrandparent(root.left);
        }
        
        if (root.right != null) {
            val += sumEvenGrandparent(root.right);
        }
        
        return val;
    }
    
    private int getValues(TreeNode node) {
        int sum = 0;
        
        if (node.left != null) {
            TreeNode left = node.left;
            if (left.left != null) {
                sum += left.left.val;
            }
            
            if (left.right != null) {
                sum += left.right.val;
            }
        }
        
        if (node.right != null) {
            TreeNode right = node.right;
            if (right.left != null) {
                sum += right.left.val;
            }
            
            if (right.right != null) {
                sum += right.right.val;
            }
        }
        
        return sum;
    }
}