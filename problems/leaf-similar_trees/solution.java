class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> f = new Stack<>();
        f.push(root1);
        Stack<TreeNode> s = new Stack<>();
        s.push(root2);
        
        while (true) {
            int fVal = getNextVal(f);
            int sVal = getNextVal(s);
            
            if (fVal == -1 && sVal == -1) {
                return true;
            }
            
            if (fVal == -1 || sVal == -1 || fVal != sVal) {
                return false;
            }
        }
    }
    
    private int getNextVal(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                return node.val;
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return -1;
    }
}