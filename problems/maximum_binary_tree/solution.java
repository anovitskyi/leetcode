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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int max = left;
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        
        return new TreeNode(nums[max], buildTree(nums, left, max - 1), buildTree(nums, max + 1, right));
    }
}