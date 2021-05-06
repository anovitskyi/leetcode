class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        
        for (int i = 0; i < encoded.length; ++i) {
            first = encoded[i] ^ first;
            result[i + 1] = first;
        }
        
        return result;
    }
}