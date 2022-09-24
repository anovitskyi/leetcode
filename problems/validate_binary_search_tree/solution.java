class Solution {
    public boolean isValidBST(TreeNode root) {
        long left = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;
        
        return isValid(root, left, right);
    }
    
    private boolean isValid(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        
        if (left >= node.val || node.val >= right) {
            return false;
        }
        
        return isValid(node.left, left, node.val) && isValid(node.right, node.val, right);
    }
}