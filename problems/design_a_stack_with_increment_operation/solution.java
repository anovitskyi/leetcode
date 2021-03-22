class CustomStack {

    private final int[] array;
    private int index;
    
    public CustomStack(int maxSize) {
        array = new int[maxSize];
        index = -1;
    }
    
    public void push(int x) {
        if (index + 1 < array.length) {
            array[++index] = x;
        }
    }
    
    public int pop() {
        if (index == -1) {
            return -1;
        }
        
        return array[index--];
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(index + 1, k);
        
        for (int i = 0; i < limit; ++i) {
            array[i] += val;
        }
    }
}