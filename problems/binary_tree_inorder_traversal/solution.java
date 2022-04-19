class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                TreeNode peek = stack.peek();
                stack.push(peek.left);
                peek.left = null;
            }
            
            TreeNode pop = stack.pop();
            result.add(pop.val);
            
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        
        return result;
    }
}