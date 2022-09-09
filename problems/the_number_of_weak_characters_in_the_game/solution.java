class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            int diff = a[0] - b[0];
            
            if (diff == 0) {
                return b[1] - a[1];
            }
            
            return diff;
        });
        
        int result = 0;
        int[] max = properties[properties.length - 1];
        
        for (int i = properties.length - 2; i >= 0; --i) {
            if (properties[i][1] < max[1]) {
                ++result;
            } else {
                max = properties[i];
            }
        }
        
        return result;
    }
}