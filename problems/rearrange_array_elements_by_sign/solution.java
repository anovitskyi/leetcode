class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int positive = 0;
        int negative = 1;

        for (int num : nums) {
            if (num >= 0) {
                result[positive] = num;
                positive += 2;
            } else {
                result[negative] = num;
                negative += 2;
            }
        }

        return result;
    }
}