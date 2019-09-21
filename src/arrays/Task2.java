package arrays;

import java.util.Arrays;

public class Task2 {

    // https://leetcode.com/problems/rotate-array/

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {-1, -100, 3, 99};

        rotate(arr, 3);
        rotate(arr2, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    // O(n^2) time
    // O(1) space
    private static void rotate(int[] nums, int k) {
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
