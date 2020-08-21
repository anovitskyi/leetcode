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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);   
        }
        
        while (!queue.isEmpty()) {
            TreeNode elem = queue.poll();
            TreeNode tmp = elem.left;
            elem.left = elem.right;
            elem.right = tmp;
            
            if (elem.left != null) {
                queue.add(elem.left);
            }
            
            if (elem.right != null) {
                queue.add(elem.right);
            }
        }
        
        return root;
    }
}