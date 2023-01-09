class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<>());
    }

    private List<Integer> traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }

        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);

        return list;
    }
}