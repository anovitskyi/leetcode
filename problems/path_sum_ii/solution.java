class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new ArrayList<>();
        
        if (root != null) {
            backtrack(root, result, curr, targetSum);
        }
        
        return result;
    }
    
    private void backtrack(TreeNode node, List<List<Integer>> result, List<Integer> curr, int target) {
        curr.add(node.val);
        target -= node.val;
        
        if (node.left == null && node.right == null && target == 0) {
            result.add(new ArrayList<>(curr));
        } 
        
        if (node.left != null) {
            backtrack(node.left, result, curr, target);
        } 
        
        if (node.right != null) {
            backtrack(node.right, result, curr, target);
        }
        
        curr.remove(curr.size() - 1);
    }
}