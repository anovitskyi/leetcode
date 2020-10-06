class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        
        int counter = 0;
        int limit = (int) Math.sqrt(bound);
        while (counter <= limit) {
            int xPow = (int) Math.pow(x, counter);
            if (xPow <= bound) {
                setX.add(xPow);
            }
            
            int yPow = (int) Math.pow(y, counter);
            if (yPow <= bound) {
                setY.add(yPow);
            }
            
            ++counter;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int xNum : setX) {
            for (int yNum: setY) {
                int sum = xNum + yNum;
                if (sum <= bound) {
                    set.add(sum);
                }
            }
        }
        
        List<Integer> result = new LinkedList<>();
        for (int elem : set) {
            result.add(elem);
        }
        return result;
    }
}