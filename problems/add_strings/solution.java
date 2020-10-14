class Solution {
    public String addStrings(String num1, String num2) {
        int last1 = num1.length() - 1;
        int last2 = num2.length() - 1;
        StringBuilder b = new StringBuilder();
        int tmp = 0;
        
        while (last1 >= 0 || last2 >= 0) {
            int f = 0;
            if (last1 >= 0) {
                f = num1.charAt(last1--) - '0';
            }
            int s = 0;
            if (last2 >= 0) {
                s = num2.charAt(last2--) - '0';
            }
            
            b.append("" + ((f + s + tmp) % 10));
            tmp = (f + s + tmp) / 10;
        }
        
        if (tmp != 0) {
            b.append("" + tmp);
        }
        
        return b.reverse().toString();
    }
}