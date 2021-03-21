class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) {
            removeLeafNodes(root.left, target);
            if (root.left.val == target && root.left.left == null && root.left.right == null) {
                root.left = null;
            }
        }
        
        if (root.right != null) {
            removeLeafNodes(root.right, target);
            if (root.right.val == target && root.right.left == null && root.right.right == null) {
                root.right = null;
            }
        }
        
        return root.val == target && root.left == null && root.right == null ? null : root;
    }
}