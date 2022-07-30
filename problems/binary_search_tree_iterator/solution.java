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
    
    private Stack<TreeNode> currStack;

    public BSTIterator(TreeNode root) {
        currStack = new Stack<>();
        currStack.push(root);
    }
    
    public int next() {
        while (currStack.peek().left != null) {
            TreeNode peek = currStack.peek();
            currStack.push(peek.left);
            peek.left = null;
        }
        
        TreeNode pop = currStack.pop();
        if (pop.right != null) {
            currStack.push(pop.right);
        }
        
        return pop.val;
    }
    
    public boolean hasNext() {
        return !currStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */