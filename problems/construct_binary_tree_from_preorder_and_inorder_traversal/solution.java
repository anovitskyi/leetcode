class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[0]);
        
        int valIndex = -1;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == preorder[0]) {
                valIndex = i;
                break;
            }
        }

        node.left = buildTree(Arrays.copyOfRange(preorder, 1, valIndex + 1), Arrays.copyOfRange(inorder, 0, valIndex));
        node.right = buildTree(Arrays.copyOfRange(preorder, valIndex + 1, preorder.length), Arrays.copyOfRange(inorder, valIndex + 1, inorder.length));

        return node;
    }
}