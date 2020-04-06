class Solution {
    public String generateTheString(int n) {
        StringBuilder b = new StringBuilder();
        
        if (n % 2 == 0) {
            b.append('a');
            --n;
        }
        
        for (int i = 0; i < n; ++i) {
            b.append('b');
        }
        
        return b.toString();
    }
}