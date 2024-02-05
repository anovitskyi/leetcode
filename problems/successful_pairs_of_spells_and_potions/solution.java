class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        
        for (int i = 0; i < spells.length; ++i) {
            int minIndex = findProductIndex(potions, success * 1.0d / spells[i]);
            result[i] = potions.length - minIndex;
        }

        return result;
    }

    private int findProductIndex(int[] potions, double desiredPotion) {
        int left = 0;
        int right = potions.length - 1;
        int result = potions.length;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            double potion = potions[mid] * 1.0d;

            if (Double.compare(potion, desiredPotion) >= 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

/**

    [3,1,2]
    [5,8,8]
    16

    []

 */