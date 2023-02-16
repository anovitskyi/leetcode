class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        List<Integer> levelList = null;
        if (level >= result.size()) {
            levelList = new ArrayList<>();
            result.add(levelList);
        } else {
            levelList = result.get(level);
        }

        levelList.add(root.val);

        traverse(root.left, level + 1, result);
        traverse(root.right, level + 1, result);
    }
}