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
    public int sumRootToLeaf(TreeNode root) { 
        if (root == null) {
            return 0;
        }
        
        return calc(root, 0);
    }
    
    private int calc(TreeNode node, int res) {
        int actual = res * 2 + node.val;
        int leftVal = 0;
        int rightVal = 0;
        
        if (node.left == null && node.right == null) {
            return actual;
        } 
        
        if (node.left != null) {
            leftVal = calc(node.left, actual);
        }
        
        if (node.right != null) {
            rightVal = calc(node.right, actual);
        }
        
        return leftVal + rightVal;
    }
    
}