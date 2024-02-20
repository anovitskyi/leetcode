class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String result = "";
        String prefix = "";

        for (int i = 0; i < Math.min(str1.length(), str2.length()); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }

            prefix += str1.charAt(i);

            if (divides(str1, prefix) && divides(str2, prefix)) {
                result = prefix;
            }
        }

        return result;
    }

    private boolean divides(String str, String div) {
        if (str.length() % div.length() != 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i += div.length()) {
            if (!str.substring(i, i + div.length()).equals(div)) {
                return false;
            }
        }

        return true;
    }
}