class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int actualAltitude = 0;
        
        for (int g : gain) {
            actualAltitude += g;
            if (actualAltitude > maxAltitude) {
                maxAltitude = actualAltitude;
            }
        }
        
        return maxAltitude;
    }
}