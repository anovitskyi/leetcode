class Solution {
    public int minOperations(int n) {
        int result = 0;
        int start = 1;
        int end = n * 2 - 1;
        
        while (start < end) {
            int ops = (end - start) / 2;
            result += ops;
            start += 2;
            end -= 2;
        }
        
        return result;
    }
}