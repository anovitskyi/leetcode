class Solution {

    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private int result = 0;

    private void traverseTree(TreeNode node, int direction, int steps) {
        if (node == null) {
            return;
        }

        if (steps > result) {
            result = steps;
        }
        
        if (direction == LEFT) {
            traverseTree(node.left, RIGHT, steps + 1);
            traverseTree(node.right, LEFT, 1);
        } else if (direction == RIGHT) {
            traverseTree(node.left, RIGHT, 1);
            traverseTree(node.right, LEFT, steps + 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        traverseTree(root, LEFT, 0);
        traverseTree(root, RIGHT, 0);
        
        return result;
    }
}