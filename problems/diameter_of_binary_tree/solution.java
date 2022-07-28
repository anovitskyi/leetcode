class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = 0;
        int leftDiameter = 0;
        if (root.left != null) {
            leftDiameter = diameterOfBinaryTree(root.left);
            leftHeight = root.left.val;
        }
        
        int rightHeight = 0;
        int rightDiameter = 0;
        if (root.right != null) {
            rightDiameter = diameterOfBinaryTree(root.right);
            rightHeight = root.right.val;
        }
        
        root.val = Math.max(leftHeight, rightHeight) + 1;
        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }
}