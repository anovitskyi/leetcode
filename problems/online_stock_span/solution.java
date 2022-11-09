class StockSpanner {

    private final Stack<int[]> stack = new Stack<>();
    
    public int next(int price) {
        int result = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            result += stack.peek()[1];
            stack.pop();
        }

        stack.push(new int[] {price, result});
        return result;
    }
}

/*

    [
        [80, 1] => 
        [100, 1] => 1
        [1000000000, 0]
    ]

 */