class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return sum(root, 1, 1);
    }
    
    private int sum(TreeNode node, int parent, int grand) {
        if (node == null) {
            return 0;
        }
        
        int sum = sum(node.left, node.val, parent) + sum(node.right, node.val, parent);
        
        if (grand % 2 == 0) {
            sum += node.val;
        }
        
        return sum;
    }
}