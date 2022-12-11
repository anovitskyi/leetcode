class Solution {
    
    public int maxPathSum(TreeNode root) {
        int[] sum = { Integer.MIN_VALUE };
        dfs(root, sum);
        return sum[0];
    }

    private int dfs(TreeNode node, int[] sum) {
        if (node==null) {
            return 0;
        }

        int left = dfs(node.left, sum);
        int right = dfs(node.right, sum);

        int nodeWithMaxChild = Math.max(left, right) + node.val;
        int nodeWithoutChildren = node.val;
        int nodeWithChildren = node.val + left + right;

        int case1 = Math.max(nodeWithMaxChild, nodeWithoutChildren);
        int case2 = Math.max(case1, nodeWithChildren);
        
        sum[0] = Math.max(sum[0], case2);
        return case1;
    }
}