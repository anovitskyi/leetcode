class Solution {
    
    // 1 2 3 4 5 6 7 8 9
    // 1 2 3 4 5 6 7 8 9
    
    // 10 11 12 13 14 15 16 17 18 19
    // 1  2  3  4  5  6  7  8  9  10
    
    // 20 21 22 23 24 25 26 27 28 29
    // 2  3  4  5  6  7  8  9  10 11
    
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; ++i) {
            int sum = getSumOfDigits(i);
            int groupSize = map.getOrDefault(sum, 0) + 1;
            map.put(sum, groupSize);
            max = Math.max(max, groupSize);
        }
        
        int result = 0;
        for (Integer groupSize : map.values()) {
            if (groupSize == max) {
                ++result;
            }
        }
        return result;
    }
    
    private int getSumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}