class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return count(root, 1, 1, getHeight(root));
    }

    private int getHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            ++height;
            root = root.left;
        }

        return height;
    }

    private int count(TreeNode node, int position, int currLevel, int lastLevel) {
        if (currLevel == lastLevel - 1) {
            if (node.left == null) {
                return -1;
            } else if (node.right != null) {
                return position * 2 + 1;
            } else {
                return position * 2;
            }
        }

        int right = count(node.right, position * 2 + 1, currLevel + 1, lastLevel);
        if (right < 0) {
            return count(node.left, position * 2, currLevel + 1, lastLevel);
        }
        return right;
    }
}