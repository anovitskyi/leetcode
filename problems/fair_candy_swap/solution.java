class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
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