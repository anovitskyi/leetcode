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
    
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeafRecursive(root);
    }
    
    public int sumRootToLeafRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        int sum = 0;
        if (root.left != null) {
            root.left.val = (root.val << 1) + root.left.val;
            sum += sumRootToLeafRecursive(root.left);
        }
        
        if (root.right != null) {
            root.right.val = (root.val << 1) + root.right.val;
            sum += sumRootToLeafRecursive(root.right);
        }
        
        return sum;
    }
    
    public int sumRootToLeafInterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                TreeNode node = queue.poll();
                
                if (node.left == null && node.right == null) {
                    result += node.val;
                } else {
                    if (node.left != null) {
                    node.left.val = (node.val << 1) + node.left.val;
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    node.right.val = (node.val << 1) + node.right.val;
                    queue.offer(node.right);
                }
                }
            }
        }
        return result;
    }
}