class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val && areSame(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean areSame(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        if (subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return areSame(root.left, subRoot.left) && areSame(root.right, subRoot.right);
    }
}