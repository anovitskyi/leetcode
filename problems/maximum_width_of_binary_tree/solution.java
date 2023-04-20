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
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));

        while (!queue.isEmpty()) {
            int size = queue.size();
            long minPosition = Long.MAX_VALUE;
            long maxPosition = Long.MIN_VALUE;

            while (size-- > 0) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                long position = pair.position;

                if (position < minPosition) {
                    minPosition = position;
                }

                if (position > maxPosition) {
                    maxPosition = position;
                }

                if (node.left != null) {
                    queue.offer(new Pair(node.left, position * 2));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, position * 2 + 1));
                }
            }

            result = Math.max(result, (int) (maxPosition - minPosition + 1));
        }

        return result;
    }

    private static class Pair {
        final long position;
        final TreeNode node;

        Pair(TreeNode node, long position) {
            this.node = node;
            this.position = position;
        }
    }
}