class Solution {
    public String convertToTitle(int n) {
        StringBuilder b = new StringBuilder();
        
        while (n > 0) {
            --n;
            int tmp = n % 26;
            b.append((char) (tmp + 65));
            n /= 26;
        }
        
        return b.reverse().toString();
    }
}