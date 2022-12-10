class Solution {

    private void dfs(TreeNode node, long[] sum) {
        if (node == null) {
            return;
        }

        sum[0] += node.val;

        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    private long checkMax(TreeNode node, long[] maxProduct, long sum) {
        if (node == null) {
            return 0;
        }

        long left = checkMax(node.left, maxProduct, sum);
        long right = checkMax(node.right, maxProduct, sum);

        maxProduct[0] = Math.max(maxProduct[0], (left + right + node.val) * (sum - left - right - node.val));
        return left + right + node.val;
    }

    public int maxProduct(TreeNode root) {
        long[] sum = {0};
        dfs(root, sum);

        long[] maxProd = {0};
        checkMax(root, maxProd, sum[0]);

        return (int) (maxProd[0] % ((int) Math.pow(10, 9) + 7));
    }
}
