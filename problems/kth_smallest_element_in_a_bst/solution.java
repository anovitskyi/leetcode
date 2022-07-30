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
        List<Integer> list = new ArrayList<>(k);
        traverse(root, k, list);
        return list.get(k - 1);
    }
    
    private void traverse(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, k, list);
        
        if (list.size() >= k) {
            return;
        }
        list.add(root.val); 
        
        traverse(root.right, k, list);
    }
}