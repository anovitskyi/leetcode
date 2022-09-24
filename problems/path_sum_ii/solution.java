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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        traverse(root, result, curr, targetSum);
        return result;
    }
    
    private void traverse(TreeNode root, List<List<Integer>> result, List<Integer> curr, int target) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                List<Integer> copy = new ArrayList<>(curr);
                copy.add(root.val);
                result.add(copy);
            }
            return;
        }
        
        curr.add(root.val);
        traverse(root.left, result, curr, target - root.val);
        traverse(root.right, result, curr, target - root.val);
        curr.remove(curr.size() - 1);
    }
}