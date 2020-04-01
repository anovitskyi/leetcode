/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        if (root.val >= L && root.val <= R) {
            res = root.val;
        }
        
        int left = 0;
        if (root.val > L) {
            left = rangeSumBST(root.left, L, R);
        }
        
        int right = 0;
        if (root.val < R) {
            right = rangeSumBST(root.right, L, R);
        }
        
        return res + left + right;
    }
}