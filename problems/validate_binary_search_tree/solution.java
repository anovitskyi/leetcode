class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= left || node.val >= right) {
            return false;
        }
        
        return isValid(node.left, left, node.val) && isValid(node.right, node.val, right);
    }
}