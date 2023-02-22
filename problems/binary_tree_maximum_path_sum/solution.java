class Solution {

    public int maxPathSum(TreeNode root) {
        int traverseResult = traverse(root);
        int rootVal = root.val;

        return Math.max(rootVal, traverseResult);
    }
    
    public int traverse(TreeNode root) {
        if (root == null) {
            return -1001;
        }

        int leftPath = traverse(root.left);
        int rightPath = traverse(root.right);
        int path = root.val;

        if (root.val + leftPath > path) {
            path = root.val + leftPath;
        }
        if (root.val + rightPath > path) {
            path = root.val + rightPath;
        }

        if (root.val + leftPath + rightPath > root.val) {
            root.val = root.val + leftPath + rightPath;
        }
        if (root.left != null && root.left.val > root.val) {
            root.val = root.left.val;
        } 
        if (root.right != null && root.right.val > root.val) {
            root.val = root.right.val;
        }
        if (path > root.val) {
            root.val = path;
        }

        return path;
    }
}