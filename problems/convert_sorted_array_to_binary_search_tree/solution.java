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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = getNode(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode getNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int middle = ((right - left) / 2) + left;
        TreeNode node = new TreeNode(nums[middle]);
        
        node.left = getNode(nums, left, middle - 1);
        node.right = getNode(nums, middle + 1, right);
        
        return node;
    }
}