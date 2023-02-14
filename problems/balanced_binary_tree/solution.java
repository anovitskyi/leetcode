class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }

        int left = root.left != null ? root.left.val + 1: 0;
        int right = root.right != null ? root.right.val + 1: 0;
        root.val = Math.max(left, right); 

        return Math.abs(left - right) <= 1;
    }
}