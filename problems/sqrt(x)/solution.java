class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        } else if (x < 4) {
            return 1;
        }

        int left = 0;
        int right = x / 2;
        int middle;
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