class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min = null;
        TreeNode max = null;
        if (p.val < q.val) {
            min = p;
            max = q;
        } else {
            min = q;
            max = p;
        }

        return findLowestAncestor(root, min, max);
    }

    private TreeNode findLowestAncestor(TreeNode root, TreeNode min, TreeNode max) {
        if (min.val <= root.val && root.val <= max.val) {
            return root;
        } else if (root.val <= min.val) {
            return findLowestAncestor(root.right, min, max);
        } else {
            return findLowestAncestor(root.left, min, max);
        }
    }
}