class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return addNode(nums, 0, nums.length - 1);
    }
    
    private TreeNode addNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int middle = (right - left) / 2 + left;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = addNode(nums, left, middle - 1);
        node.right = addNode(nums, middle + 1, right);
        return node;
    }
}