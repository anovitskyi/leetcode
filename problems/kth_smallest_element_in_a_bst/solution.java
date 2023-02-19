class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return findSmallest(root, new int[] {k});
    }

    private int findSmallest(TreeNode root, int[] k) {
        if (root == null) {
            return -1;
        }

        int left = findSmallest(root.left, k);
        if (left != -1) {
            return left;
        }

        if (--k[0] == 0) {
            return root.val;
        }

        return findSmallest(root.right, k);
    }
}