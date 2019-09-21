package arrays;

import java.util.Arrays;
import java.util.Random;

public class Task3 {

    // https://leetcode.com/problems/shuffle-an-array/

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Solution solution = new Solution(arr);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
    }

    // O(n) time
    // O(n) space
    private static class Solution {

        private int[] nums;
        private int[] origin;
        private Random random;

        public Solution(int[] nums) {
            this.origin = nums;
            this.nums = new int[nums.length];
            this.random = new Random();
            System.arraycopy(this.origin, 0, this.nums, 0, this.origin.length);
        }

        public int[] reset() {
            System.arraycopy(origin, 0, nums, 0, origin.length);
            return nums;
        }

        public int[] shuffle() {
            for (int i = 0; i < nums.length; ++i) {
                int rand = random.nextInt(nums.length);
                int tmp = nums[i];
                nums[i] = nums[rand];
                nums[rand] = tmp;
            }
            return nums;
        }
    }

}
