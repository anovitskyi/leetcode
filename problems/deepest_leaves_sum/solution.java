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
    public int deepestLeavesSum(TreeNode root) {
        List<Integer> levelsSum = new ArrayList<>();
        sumLeavesNodes(root, levelsSum, 0);
        return levelsSum.get(levelsSum.size() - 1);
    }
    
    private void sumLeavesNodes(TreeNode root, List<Integer> levelsSum, int level) {
        if (root == null) {
            return;
        }
        
        if (levelsSum.size() <= level) {
            levelsSum.add(root.val);
        } else {
            levelsSum.set(level, levelsSum.get(level) + root.val);
        }
        
        sumLeavesNodes(root.left, levelsSum, level + 1);
        sumLeavesNodes(root.right, levelsSum, level + 1);
    }
}