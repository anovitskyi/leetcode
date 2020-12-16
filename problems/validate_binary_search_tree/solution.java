class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkSubTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean checkSubTree(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        return checkSubTree(node.left, min, node.val) && checkSubTree(node.right, node.val, max);
    }
}