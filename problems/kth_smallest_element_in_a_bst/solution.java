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
        return findKthSmallestElement(root, k, new LinkedList<>());
    }
    
    private int findKthSmallestElement(TreeNode node, int k, List<Integer> visitedElements) {
        if (node == null) {
            return -1;
        }
        
        int left = findKthSmallestElement(node.left, k, visitedElements);
        if (left != -1) {
            return left;
        }
        
        visitedElements.add(node.val);
        if (visitedElements.size() == k) {
            return visitedElements.get(k - 1);
        }
        
        int right = findKthSmallestElement(node.right, k, visitedElements);
        if (right != -1) {
            return right;
        }
        
        return -1;
    }
}