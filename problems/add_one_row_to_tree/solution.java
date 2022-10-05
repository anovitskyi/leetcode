class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return preOrder(root, val, depth, 1, -1);
    }
    
    private TreeNode preOrder(TreeNode node, int val, int depth, int currDepth, int side) {
        if (depth == currDepth) {
            TreeNode tmp = new TreeNode(val);
            if (side < 0) {
                tmp.left = node;
            } else if (side > 0) {
                tmp.right = node;
            }
            return tmp;
        }
        
        if (node != null) {
            node.left = preOrder(node.left, val, depth, currDepth + 1, -1);
            node.right = preOrder(node.right, val, depth, currDepth + 1, 1);
        }
        
        return node;
    }
}