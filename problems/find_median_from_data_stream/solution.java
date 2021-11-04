class MedianFinder {
    
    private final Queue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
    private final Queue<Integer> max = new PriorityQueue<>();
    
    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            
            if (min.size() - max.size() > 1) {
                max.offer(min.poll());
            }
        } else {
            max.offer(num);
            
            if (max.size() - min.size() > 0) {
                min.offer(max.poll());
            }
        }
    }
    
    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek() * 1.0d;
        } else {
            return (min.peek() + max.peek()) / 2.0d;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */