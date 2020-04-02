class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (true) {
            int res = 0;
            
            while (n > 0) {
                int last = n % 10;
                res += last * last;
                n /= 10;
            }
            
            if (res == 1) {
                return true;
            }
            
            if (set.contains(res)) {
                return false;
            } else {
                set.add(res);
            }
            
            n = res;
        }
        
    }
}