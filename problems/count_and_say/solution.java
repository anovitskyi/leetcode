class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        StringBuilder b = new StringBuilder();
        String prev = countAndSay(n - 1);
        
        for (int i = 0; i < prev.length(); ) {
            int index = i + 1;
            
            while (index < prev.length() && prev.charAt(index) == prev.charAt(i)) {
                ++index;
            }
            
            b.append(index - i).append(prev.charAt(i));
            i = index;
        }
        
        return b.toString();
    }
}