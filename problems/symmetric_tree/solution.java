class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        return areSame(root.left, root.right);
    }
    
    private boolean areSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        
        if (a == null || b == null) {
            return false;
        }
        
        if (a.val != b.val) {
            return false;
        }
        
        if (!areSame(a.left, b.right)) {
            return false;
        }
        
        if (!areSame(a.right, b.left)) {
            return false;
        }
        
        return true;
    }
    
}