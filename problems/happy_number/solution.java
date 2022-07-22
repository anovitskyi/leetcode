class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        
        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            
            int tmp = 0;
            while (n > 0) {
                int last = n % 10;
                tmp += (last * last);
                n = n / 10;
            }
            n = tmp;
        }
        
        return true;
    }
}