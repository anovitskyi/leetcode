class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int digitsSum = 0;
            int copy = num;
            while (copy > 0) {
                digitsSum += copy % 10;
                copy /= 10;
            }
            
            Queue<Integer> queue = map.computeIfAbsent(digitsSum, k -> new PriorityQueue<>());
            queue.offer(num);
            if (queue.size() > 2) {
                queue.poll();
            }
        }
        
        int result = -1;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() < 2) {
                continue;
            }
            
            result = Math.max(result, entry.getValue().poll() + entry.getValue().poll());
        }
        return result;
    }
}








/* 
                                                                            |
    [368,369,307,304,384,138,90,279,35,396,114,328,251,364,300,191,438,467,183]
    
    17 -> 368, 467 = 
    18 -> 369, 396
    10 -> 307
    7  -> 304, 35
    15 -> 384, 438
    12 -> 138, 183
    9  -> 90
    6  -> 114
    13 -> 328, 364
    8  -> 251
    3  -> 300
    11 -> 191
    

*/












