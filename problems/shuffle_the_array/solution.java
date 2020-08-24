class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int h = nums.length / 2;
        int b = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[b++];
            result[i + 1] = nums[h++];
        }
        return result;
    }
}