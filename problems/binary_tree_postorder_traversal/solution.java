class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            
            if (top.left == null && top.right == null) {
                result.add(stack.pop().val);
            }
            
            if (top.right != null) {
                stack.push(top.right);
                top.right = null;
            }
            
            if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            }
        }
        
        return result;
    }
    
    
}