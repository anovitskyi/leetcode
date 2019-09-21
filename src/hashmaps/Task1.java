package hashmaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task1 {

    // https://leetcode.com/problems/fair-candy-swap/

    public static void main(String[] args) {
        int[] res = fairCandySwap2(new int[]{1, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(res));
    }

    // O(a * b) time
    // O(1) space
    private static int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0;
        int bSum = 0;

        for (int i = 0; i < A.length; ++i) {
            aSum += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            bSum += B[i];
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (aSum - A[i] + B[j] == bSum - B[j] + A[i]) {
                    return new int[] {A[i], B[j]};
                }
            }
        }

        return null;
    }

    // O(n) time
    // O(b) space
    private static int[] fairCandySwap2(int[] A, int[] B) {
        int aSum = 0;
        int bSum = 0;
        Set<Integer> bSet = new HashSet<>(B.length);

        for (int i = 0; i < A.length; ++i) {
            aSum += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            bSum += B[i];
            bSet.add(B[i]);
        }

        int diff = (bSum - aSum) / 2;
        for (int i = 0; i < A.length; i++) {
            int desiredB = diff + A[i];
            if (bSet.contains(desiredB)) {
                return new int[] {A[i], desiredB};
            }
        }

        return null;
    }

}
