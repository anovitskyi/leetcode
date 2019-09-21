class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop >= Integer.MAX_VALUE % 10)) {
                return 0;
            } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop <= Integer.MIN_VALUE % 10)) {
                return 0;
            }
            
            result = result * 10 + pop;
            x /= 10;
        }
        return result;
    }
}