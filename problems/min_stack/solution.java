class MinStack {

    private class Pair {
        final int val;
        final int min;
        
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
    private Stack<Pair> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        int val = x;
        int min = x;
        
        if (!stack.isEmpty() && min > getMin()) {
            min = getMin();
        }
        
        stack.push(new Pair(val, min));
    }
    
    public void pop() {
       stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
       return stack.peek().min;
    }
}



// class MinStack {

//     private Stack<Integer> stack;
//     private Stack<Integer> min;
    
//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack<>();
//         min = new Stack<>();
//     }
    
//     public void push(int x) {
//         stack.push(x);
//         if (min.isEmpty() || min.peek() >= x) {
//             min.push(x);
//         }
//     }
    
//     public void pop() {
//         int rem = stack.pop();
//         if (min.peek() == rem) {
//             min.pop();
//         }
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return min.peek();
//     }
// }



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */