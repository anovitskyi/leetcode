class Solution {
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        
        for (int i = 1; i < result.length; ++i) {
            result[i] = pref[i - 1] ^ pref[i];
        }
        
        return result;
    }
}

// 5 ^ 2 => 0101 ^ 0010 => 0111 => 7
// 2 ^ 0 => 0010 ^ 0000 => 0010 => 2
// 0 ^ 3 => 0000 ^ 0011 => 0011 => 3
// 3 ^ 1 => 0011 ^ 0001 => 0010 => 2

