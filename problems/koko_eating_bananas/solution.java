class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 1_000_000_000;
        
        while (minSpeed < maxSpeed) {
            int speed = (maxSpeed - minSpeed) / 2 + minSpeed;
            int hoursPerSpeed = 0;
            for (int pile : piles) {
                hoursPerSpeed += Math.ceil((double) pile / speed);
            }
            
            if (hoursPerSpeed <= h) {
                maxSpeed = speed;
            } else {
                minSpeed = speed + 1;
            }
        }
        
        return maxSpeed;
    }
}