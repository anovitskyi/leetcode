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
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if (root == null) {
//             return 0;
//         }
        
//         if (root.val < low) {
//             return rangeSumBST(root.right, low, high);
//         } else if (root.val > high) {
//             return rangeSumBST(root.left, low, high);
//         }
        
        
//         return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
//     }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            } 
            
            if (node.val >= low && node.left != null) {
                queue.offer(node.left);
            } 
            
            if (node.val <= high && node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return sum;
    }
}