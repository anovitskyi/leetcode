class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return traverse(root, root, k);
    }
    
    private boolean traverse(TreeNode curr, TreeNode root, int target) {
        if (curr == null) {
            return false;
        }
        
        TreeNode elem = findElement(root, target - curr.val);
        if (elem != null && elem != curr) {
            return true;
        }
        
        return traverse(curr.left, root, target) || traverse(curr.right, root, target);
    }
    
    private TreeNode findElement(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
    
        if (root.val == target) {
            return root;
        }
        
        if (target > root.val) {
            return findElement(root.right, target);
        } else {
            return findElement(root.left, target);
        }
    }
}