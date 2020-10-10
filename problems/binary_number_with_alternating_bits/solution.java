class Solution {
    public boolean hasAlternatingBits(int n) {
        int last = n % 2;
        n /= 2;
        
        while (n > 0) {
            int tmp = n % 2;
            if (tmp == last) {
                return false;
            }
            last = tmp;
            n /= 2;
        }
        
        return true;
    }
}


// 1 -> 01 -> true
// 2 -> 10 -> true
// 3 -> 11 -> false
// 4 -> 100 -> false
// 5 -> 101 -> true

