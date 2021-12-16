class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        for (int size : aliceSizes) {
            aliceSum += size;
        }
        
        Set<Integer> bobBoxes = new HashSet<>();
        int bobSum = 0;
        for (int size : bobSizes) {
            bobBoxes.add(size);
            bobSum += size;
        }
        
        int middle = (bobSum + aliceSum) / 2;
        
        for (int ab : aliceSizes) {
            int expected = middle - (aliceSum - ab);
            if (bobBoxes.contains(expected)) {
                return new int[] {
                    ab, expected
                };
            }
        }
        
        return new int[0];
    }
}