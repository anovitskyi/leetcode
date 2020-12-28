class Solution {
    public int numberOfMatches(int n) { // 1
        int mod = 0;
        int played = 0;
        while (n > 1) {
            mod = n % 2; // 0
            int half = n / 2; // 1
            played += half; // 3 5 6
            n = half + mod;
        }
        return played;
    }
}