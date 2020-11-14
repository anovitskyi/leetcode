class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longestDuration = releaseTimes[0];
        char longestChar = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; ++i) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            
            if (duration > longestDuration || (duration == longestDuration && keysPressed.charAt(i) > longestChar)) {
                longestDuration = duration;
                longestChar = keysPressed.charAt(i);
            }
        }
        
        return longestChar;
    }
}