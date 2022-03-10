class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int currSum = 0;
        int result = 0;
        
        for (int i = 0; i < gas.length; ++i) {
            int diff = gas[i] - cost[i];
            sum += diff;
            currSum += diff;
            if (currSum < 0) {
                currSum = 0;
                result = i + 1;
            }
        }
        
        if (sum < 0) {
            return -1;
        }
        
        return result;
    }
}