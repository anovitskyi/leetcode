class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                TreeNode peek = stack.peek();
                stack.push(peek.left);
                peek.left = null;
            }
            
            TreeNode top = stack.pop();
            result.add(top.val);
            
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        
        return result;
    }
}