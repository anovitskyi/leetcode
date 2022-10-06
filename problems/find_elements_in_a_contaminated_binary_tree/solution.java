class FindElements {
    
    private final Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        traverseTree(root);
    }
    
    private void traverseTree(TreeNode node) {
        set.add(node.val);
        
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            traverseTree(node.left);
        }
        
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            traverseTree(node.right);
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}