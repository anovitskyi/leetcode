class Solution {
    public String addBinary(String a, String b) {
         char[] longer, shorter;
        if (a.length() >= b.length()) {
            longer = a.toCharArray();
            shorter = b.toCharArray();
        } else {
            longer = b.toCharArray();
            shorter = a.toCharArray();
        }

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = shorter.length - 1, j = longer.length - 1; i >= 0; --i, --j) {
            int sum = shorter[i] - '0' + longer[j] - '0' + carry;
            builder.append(sum % 2);
            carry = sum / 2;
        }

        for (int i = longer.length - shorter.length - 1; i >= 0; --i) {
            int sum = longer[i] - '0' + carry;
            builder.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }
}