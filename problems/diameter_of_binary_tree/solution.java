class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }        

        int maxChild = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        int leftChild = root.left != null ? root.left.val + 1 : 0;
        int rightChild = root.right != null ? root.right.val + 1 : 0;

        root.val = Math.max(leftChild, rightChild);
        return Math.max(maxChild, leftChild + rightChild);
    }
}