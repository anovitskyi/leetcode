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
    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallest(root, k, new LinkedList<>());
    }
    
    private int findKthSmallest(TreeNode node, int k, List<Integer> elements) {
        if (node == null) {
            return -1;
        }
        
        int left = findKthSmallest(node.left, k, elements);
        if (left != -1) {
            return left;
        }
        
        elements.add(node.val);
        if (elements.size() == k) {
            return node.val;
        }
        
        int right = findKthSmallest(node.right, k, elements);
        if (right != -1) {
            return right;
        }
        
        return -1;
    }
}