class StockSpanner {

    private final Stack<int[]> stack = new Stack<>();
    
    public int next(int price) {
        int counter = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            counter += stack.pop()[1];
        }

        stack.push(new int[] { price, counter });
        return counter;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */