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
    public TreeNode convertBST(TreeNode root) {
        List<Integer> prev = new LinkedList<>();
        prev.add(0);
        return convertBST(root, prev);
    }
    
    private TreeNode convertBST(TreeNode node, List<Integer> list) {
        if (node == null) {
            return node;
        }
        
        convertBST(node.right, list);
        
        node.val += list.get(list.size() - 1);
        list.add(node.val);
        
        convertBST(node.left, list);
        
        return node;
    }
}