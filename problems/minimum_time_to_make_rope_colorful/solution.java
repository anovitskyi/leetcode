class Solution {
    public int minCost(String colors, int[] neededTime) {
        int result = 0;
        
        int prev = 0;
        int curr = 1;
        while (curr < colors.length()) {
            if (colors.charAt(prev) == colors.charAt(curr)) {
                ++curr;
                continue;
            }
            
            if (curr - prev > 1) {
                int max = -1;
                int sum = 0;
                for (int i = prev; i < curr; ++i) {
                    sum += neededTime[i];
                    if (neededTime[i] > max) {
                        max = neededTime[i];
                    }
                }
                result += sum;
                result -= max;
            }
            
            prev = curr;
            ++curr;
        }
        
        if (curr - prev > 1) {
            int max = -1;
                int sum = 0;
                for (int i = prev; i < curr; ++i) {
                    sum += neededTime[i];
                    if (neededTime[i] > max) {
                        max = neededTime[i];
                    }
                }
                result += sum;
                result -= max;
        }
        
        return result;
    }
}