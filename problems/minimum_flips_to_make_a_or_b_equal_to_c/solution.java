class Solution {
    public int minFlips(int a, int b, int c) {
        int result = 0;

        for (int i = 0; i < 32; ++i, a /= 2, b /= 2, c /= 2) {
            int lastA = a % 2;
            int lastB = b % 2;
            int lastC = c % 2;

            if ((lastA | lastB) == lastC) {
                continue;
            }

            if (lastC == 1) {
                result += 1;
            } else {
                result += lastA + lastB;
            }
        }

        return result;
    }
}