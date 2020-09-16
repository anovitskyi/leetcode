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
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        
        int min = Integer.MAX_VALUE;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            set.add(tmp.val);
            if (tmp.val < min) {
                min = tmp.val;
            }
            
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        
        if (set.size() < 2) {
            return -1;
        }
        
        int res = Integer.MAX_VALUE;
        for (int num : set) {
            if (num < res && num > min) {
                res = num;
            }
        }
        return res;
    }
}