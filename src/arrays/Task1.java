package arrays;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    // https://leetcode.com/problems/find-all-duplicates-in-an-array/

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] arr2 = {10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        System.out.println(findDuplicates2(arr2));

    }

    // O(n) - time
    // O(1) - space, except list of results
    private static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index] *= -1;
            }
        }

        return duplicates;
    }

    // O(n) - time
    // O(n) - space
    private static List<Integer> findDuplicates(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            if (flags[num - 1]) {
                duplicates.add(num);
            } else {
                flags[num - 1] = true;
            }
        }

        return duplicates;
    }

}
