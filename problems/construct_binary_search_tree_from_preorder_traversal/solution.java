class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return traverse(preorder, 0, preorder.length);
    }
    
    private TreeNode traverse(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        
        TreeNode node = new TreeNode(nums[left]);
        int middle = right;
        for (int i = left + 1; i < right; ++i) {
            if (nums[i] > nums[left]) {
                middle = i;
                break;
            }
        }
        
        node.left = traverse(nums, left + 1, middle);
        node.right = traverse(nums, middle, right);
        return node;
    }
}