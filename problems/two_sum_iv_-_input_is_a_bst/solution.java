class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }
    
    private boolean findTarget(TreeNode root, TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        
        TreeNode second = findNode(root, target - node.val);
        if (second != null && second != node) {
            return true;
        }
        
        return findTarget(root, node.left, target) || findTarget(root, node.right, target);
    }
    
    private TreeNode findNode(TreeNode node, int target) {
        if (node == null || node.val == target) {
            return node;
        }
        
        if (node.val < target) {
            return findNode(node.right, target);
        } else {
            return findNode(node.left, target);
        }
    }
}