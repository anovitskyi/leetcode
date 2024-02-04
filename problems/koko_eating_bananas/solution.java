class Solution {
    public int minEatingSpeed(int[] piles, long targetTime) {
        int minVelocity = 1;
        int maxVelocity = Integer.MIN_VALUE;

        for (int pile : piles) {
            if (pile > maxVelocity) {
                maxVelocity = pile;
            }
        }

        int result = -1;
        while (minVelocity <= maxVelocity) {
            int velocity = (maxVelocity - minVelocity) / 2 + minVelocity;
            long calculatedTime = calculateTime(piles, velocity);

            if (calculatedTime <= targetTime) {
                result = velocity;
                maxVelocity = velocity - 1;
            } else {
                minVelocity = velocity + 1;
            }
        }
        return result;
    }

    private long calculateTime(int[] piles, int velocity) {
        long time = 0;
        for (int pile : piles) {
            time += pile / velocity;
            time += pile % velocity > 0 ? 1 : 0;
        }
        return time;
    }
}

/**

    30,11,23,4,20

    4,11,20,23,30

    sum = 88
    min = 4
    max = 30
    h = 5

    mid = 17
    velocity = 88 / 17 = 5


 */