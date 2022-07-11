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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> levels = new ArrayList<>();
        dfsLevels(root, 0, levels);
        return levels;
    }
    
    private void dfsLevels(TreeNode root, int currLevel, List<Integer> levels) {
        if (root == null) {
            return;
        }
        
        if (currLevel >= levels.size()) {
            levels.add(root.val);
        }
        
        dfsLevels(root.right, currLevel + 1, levels);
        dfsLevels(root.left, currLevel + 1, levels);
    }
    
   
}