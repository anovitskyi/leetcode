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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new LinkedList<>();
        traverse(root1, result);
        traverse(root2, result);
        Collections.sort(result);
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}