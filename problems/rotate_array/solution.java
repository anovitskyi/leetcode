class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }

        k %= nums.length;

        while (k-- > 0) {
            int tmp = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                int x = nums[i];
                nums[i] = tmp;
                tmp = x;
            }
            nums[0] = tmp;
        }

    }
}