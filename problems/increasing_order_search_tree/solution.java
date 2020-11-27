class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        
        for (int i = 1; i < list.size(); ++i) {
            list.get(i).left = null;
            list.get(i - 1).right = list.get(i);
        }
        
        return list.get(0);
    }
    
    private void traverse(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        
        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);
    }
}