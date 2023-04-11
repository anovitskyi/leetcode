class Solution {
    public String removeStars(String s) {
        char[] result = s.toCharArray();
        int read = 0;
        int write = 0;

        while (read < s.length()) {
            if (result[read] == '*') {
                write--;
            } else {
                result[write] = result[read];
                ++write;
            }
            
            ++read;
        }

        return new String(result, 0, write);
    }
}