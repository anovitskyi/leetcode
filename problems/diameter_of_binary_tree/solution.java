class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int max = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        
        int left = 0;
        if (root.left != null) {
            left = root.left.val + 1;
        }
        
        int right = 0;
        if (root.right != null) {
            right = root.right.val + 1;
        }
        
        root.val = Math.max(left, right);
        
        return Math.max(max, left + right);
    }
}