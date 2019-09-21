package strings;

import java.util.Arrays;

public class Task2 {

    // https://leetcode.com/problems/string-compression/

    public static void main(String[] args) {
        System.out.println(compress2("aabbbccccde".toCharArray()));
    }

    // O(n^2) time
    // O(n) space
    private static int compress(char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; ) {
            int counter = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    ++counter;
                } else {
                    break;
                }
            }
            builder.append(chars[i]);
            if (counter > 1) {
                builder.append(counter);
            }

            i += counter;
        }
        builder.getChars(0, builder.length(), chars, 0);
        return builder.length();
    }

    // O(n) time
    // O(1) space
    private static int compress2(char[] chars) {
        int read, write = 0;

        for (read = 0; read < chars.length;) {
            int counter = 1;
            chars[write++] = chars[read];
            while (read + counter < chars.length && chars[read + counter] == chars[read]) ++counter;
            read += counter;

            if (counter > 1) {
                char[] num = Integer.toString(counter).toCharArray();
                for (int i = 0; i < num.length; ++i) {
                    chars[write++] = num[i];
                }
            }
        }

        return write;
    }

}
