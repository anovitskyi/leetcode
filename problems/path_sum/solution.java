class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        int newSum = targetSum - root.val;
        if (root.left == null && root.right == null && newSum == 0) {
            return true;
        }
        
        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
}