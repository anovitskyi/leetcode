class Solution {
    public int averageOfSubtree(TreeNode root) {
        int left = 0;
        int leftSum = 0;
        int leftQuantity = 0;
        if (root.left != null) {
            left = averageOfSubtree(root.left);
            leftSum = root.left.val >>> 12;
            leftQuantity = root.left.val & 0xfff;
        }

        int right = 0;
        int rightSum = 0;
        int rightQuantity = 0;
        if (root.right != null) {
            right = averageOfSubtree(root.right);
            rightSum = root.right.val >>> 12;
            rightQuantity = root.right.val & 0xfff;
        }
        
        int sum = leftSum + rightSum + root.val;
        int quantity = leftQuantity + rightQuantity + 1;
        int prevVal = root.val;
        int average = sum / quantity;
        root.val = (sum << 12) | (quantity & 0xfff);

        return left + right + (prevVal == average ? 1 : 0);
    }
}