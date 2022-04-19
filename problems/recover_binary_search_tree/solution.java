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
    public void recoverTree(TreeNode root) {
        Queue<Integer> elements = new PriorityQueue<>();
        traverseElements(root, elements);
        updateElementsValues(root, elements);
    }
    
    private void updateElementsValues(TreeNode node, Queue<Integer> elements) {
        if (node == null) {
            return;
        }
        
        updateElementsValues(node.left, elements);
        node.val = elements.poll();
        updateElementsValues(node.right, elements);
    }
    
    private void traverseElements(TreeNode node, Queue<Integer> elements) {
        if (node == null) {
            return;
        }
        
        traverseElements(node.left, elements);
        elements.offer(node.val);
        traverseElements(node.right, elements);
    }
}