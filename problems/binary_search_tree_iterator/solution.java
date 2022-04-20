/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    
    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        stack.push(root);
    }
    
    public int next() {
        while (stack.peek().left != null) {
            TreeNode peek = stack.peek();
            stack.push(peek.left);
            peek.left = null;
        }
        
        TreeNode pop = stack.pop();
        if (pop.right != null) {
            stack.push(pop.right);
        }
        
        return pop.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */