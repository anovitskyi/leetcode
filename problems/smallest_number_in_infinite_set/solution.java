class SmallestInfiniteSet {
    
    private Queue<Integer> carry = new PriorityQueue<>();
    private int counter = 1;
    
    public int popSmallest() {
        if (!carry.isEmpty()) {
            int peek = carry.peek();
            while (!carry.isEmpty() && carry.peek() == peek) {
                carry.poll();
            }
            return peek;
        } else {
            return counter++;
        }
    }
    
    public void addBack(int num) {
        if (num >= counter) {
            return;
        }

        carry.offer(num);
    }
}