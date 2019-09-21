package strings;

import java.util.Arrays;

public class Task1 {

    // https://leetcode.com/problems/di-string-match/

    public static void main(String[] args) {
        String s1 = "IDID";
        String s2 = "III";
        String s3 = "DDI";

        System.out.println(Arrays.toString(diStringMatch(s1)));
        System.out.println(Arrays.toString(diStringMatch(s2)));
        System.out.println(Arrays.toString(diStringMatch(s3)));
    }

    // O(n) time
    // O(n) space
    private static int[] diStringMatch(String S) {
        char[] chars = S.toCharArray();
        int[] result = new int[chars.length + 1];
        int ds = chars.length;
        int is = 0;

        for (int i = 0; i < chars.length; ++i) {
            result[i] = chars[i] == 'I' ? is++ : ds--;
        }
        result[chars.length] = ds >= 0 ? ds : is;

        return result;
    }

}
