class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int counter = root.val >= max ? 1 : 0;
        int newMax = Math.max(root.val, max);

        return countGoodNodes(root.left, newMax) + countGoodNodes(root.right, newMax) + counter;
    }
}