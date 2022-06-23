class Solution {
    public boolean isHappy(int n) {
        Set<Integer> prev = new HashSet<>();
        
        while (true) {
            if (n == 1) {
                return true;
            }
            
            int tmp = 0;
            while (n > 0) {
                int last = n % 10;
                tmp = tmp + (last * last);
                n = n / 10;
            }
            
            if (!prev.add(tmp)) {
                return false;
            }
            
            n = tmp;
        }
    }
}