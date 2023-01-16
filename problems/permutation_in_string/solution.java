class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] desArr = new int[26];
        int[] currArr = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            ++desArr[s1.charAt(i) - 'a'];
            ++currArr[s2.charAt(i) - 'a'];
        }

        for (int i = s1.length(); i < s2.length(); ++i) {
            if (areSame(desArr, currArr)) {
                return true;
            }

            --currArr[s2.charAt(i - s1.length()) - 'a'];
            ++currArr[s2.charAt(i) - 'a'];
        }

        return areSame(desArr, currArr);
    }

    private boolean areSame(int[] source, int[] target) {
        for (int i = 0; i < source.length; ++i) {
            if (source[i] != target[i]) {
                return false;
            }
        }

        return true;
    }
}