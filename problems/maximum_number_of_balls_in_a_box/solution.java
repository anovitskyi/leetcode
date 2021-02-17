class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        
        for (int i = lowLimit; i <= highLimit; ++i) {
            int sum = 0;
            int number = i;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            
            int counter = map.getOrDefault(sum, 0);
            ++counter;
            map.put(sum, counter);
            
            result = Math.max(result, counter);
        }
        
        return result;
    }
}