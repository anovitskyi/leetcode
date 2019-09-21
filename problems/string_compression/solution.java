class Solution {
    public int compress(char[] chars) {
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