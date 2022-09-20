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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            if (stack.peek().left != null) {
                TreeNode peek = stack.peek();
                stack.push(peek.left);
                peek.left = null;
                continue;
            }
            
            TreeNode top = stack.pop();
            result.add(top.val);
            
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        
        return result;
    }
}