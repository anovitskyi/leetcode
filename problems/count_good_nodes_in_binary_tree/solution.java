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
    public int goodNodes(TreeNode root) {
        int result = 1;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode last = stack.pop();
            
            if (last.left != null) {
                if (last.left.val >= last.val) {
                    ++result;
                } else {
                    last.left.val = last.val;
                }
                
                stack.push(last.left);
            }
            
            if (last.right != null) {
                if (last.right.val >= last.val) {
                    ++result;
                } else {
                    last.right.val = last.val;
                }
                
                stack.push(last.right);
            }
        }
        
        
        return result;
    }
}