class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x < 4) {
            return 1;
        }

        int left = 0;
        int right = x;
        int middle = -1;
        int res = -1;

        while (left <= right) {
            middle = (left + right) / 2;
            int tmp = x / middle;

            if (middle == tmp) {
                return tmp;
            } else if (tmp > middle) { 
                left = middle + 1;
                res = middle;
            } else {
                right = middle - 1;
            }
        }

        return res;
    }
}