class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        
        for (int i = 0; i < list.size() - 1; ++i) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        
        return list.get(0);
    }
    
    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node.left != null) {
            dfs(node.left, list);
        }
        
        list.add(node);
        
        if (node.right != null) {
            dfs(node.right, list);
        }
    }
}