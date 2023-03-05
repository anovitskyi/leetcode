class MedianFinder {

    private final Queue<Integer> firstHalf = new PriorityQueue<>((a, b) -> b - a);
    private final Queue<Integer> secondHalf = new PriorityQueue<>();
    
    public void addNum(int num) {
        if (firstHalf.isEmpty() || num <= firstHalf.peek()) {
            firstHalf.offer(num);
        } else {
            secondHalf.offer(num);
        }

        int sizeDiff = firstHalf.size() - secondHalf.size();
        if (sizeDiff < 0) {
            firstHalf.offer(secondHalf.poll());
        } else if (sizeDiff > 1) {
            secondHalf.offer(firstHalf.poll());
        }
    }
    
    public double findMedian() {
        int size = firstHalf.size() + secondHalf.size();

        if (size % 2 == 1) {
            return firstHalf.peek() * 1.0d;
        } else {
            return (firstHalf.peek() + secondHalf.peek()) / 2.0d;
        }
    }
}