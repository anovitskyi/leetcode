class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n - 1);
        StringBuilder b = new StringBuilder();
        
        int index = 0;
        while (index < prev.length()) {
            int start = index;
            int curr = index + 1;
            while (curr < prev.length() && prev.charAt(start) == prev.charAt(curr)) {
                ++curr;
            }
            
            b.append(curr - start).append(prev.charAt(start));
            index = curr;
        }
        
        return b.toString();
    }
}