class Solution {
    public int titleToNumber(String s) {
        char[] tab = s.toCharArray();
        
        int result = 0;
        
        for (int i = 0; i < tab.length; ++i) {
            int level = (int) Math.pow(26, tab.length - i - 1);
            int value = (tab[i] - 'A' + 1) * level;
            result += value;
        }
        
        return result;
    }
}

// A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
// 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25