class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            
            if (pop.right != null) {
                stack.push(pop.right);
            }
            
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        
        return result;
    }
}