package arrays;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    // https://leetcode.com/problems/find-all-duplicates-in-an-array/

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));
    }

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
