class Solution {
    
    private int sum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    
    private void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.right);
            node.val += sum;
            sum = node.val;
            traverse(node.left);
        }
    }
    
}