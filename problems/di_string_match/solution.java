class Solution {
    public int[] diStringMatch(String S) {
        char[] chars = S.toCharArray();
        int[] result = new int[chars.length + 1];
        int ds = chars.length;
        int is = 0;

        for (int i = 0; i < chars.length; ++i) {
            result[i] = chars[i] == 'I' ? is++ : ds--;
        }
        result[chars.length] = chars[chars.length - 1] == 'I' ? is : ds;

        return result;
    }
}