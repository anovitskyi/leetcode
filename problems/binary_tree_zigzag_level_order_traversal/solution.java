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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isNaturalOrder = true;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> elements = new LinkedList<>();
            while (size-- > 0) {
                TreeNode topNode = queue.poll();
                if (topNode.left != null) {
                    queue.offer(topNode.left);
                }
                if (topNode.right != null) {
                    queue.offer(topNode.right);
                }
                if (isNaturalOrder) {
                    elements.offerLast(topNode.val);
                } else {
                    elements.offerFirst(topNode.val);
                }
            }
            isNaturalOrder = !isNaturalOrder;
            result.add(elements);
        }
        
        return result;
    }
}