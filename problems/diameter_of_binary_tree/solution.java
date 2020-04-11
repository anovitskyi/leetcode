/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
int diameter=0;
    private int maxHeight(TreeNode root){
        if(root==null)
            return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        diameter = Math.max(left+right,diameter);
        return Math.max(left,right)+1;
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return diameter ;
    }
    
}