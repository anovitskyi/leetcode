class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < a.length() || i < b.length(); ++i) {
            int aNum = 0;
            int bNum = 0;
            
            if (i < a.length()) {
                aNum = a.charAt(a.length() - i - 1) - '0';
            } 
            
            if (i < b.length()) {
                bNum = b.charAt(b.length() - i - 1) - '0';
            }
            
            int curr = aNum + bNum + carry;
            result.append(curr % 2);
            carry = curr / 2;
        }
        
        if (carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}