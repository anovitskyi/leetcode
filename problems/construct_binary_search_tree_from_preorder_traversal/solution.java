class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for (int i = 1; i < preorder.length; ++i) {
            insert(root, new TreeNode(preorder[i]));
        }
        
        return root;
    }
    
    private void insert(TreeNode root, TreeNode curr) {
        if (curr.val < root.val) {
            if (root.left == null) {
                root.left = curr;
            } else {
                insert(root.left, curr);
            }
        } else {
            if (root.right == null) {
                root.right = curr;
            } else {
                insert(root.right, curr);
            }
        }
    }
}