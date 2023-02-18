class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>(k);
        traverse(root, k, result);
        return result.get(k - 1);   
    }

    private void traverse(TreeNode root, int k, List<Integer> result) {
        if (root == null) {
            return;
        }

        traverse(root.left, k, result);

        if (result.size() < k) {
            result.add(root.val);
        } else {
            return;
        }

        traverse(root.right, k, result);
    }
}