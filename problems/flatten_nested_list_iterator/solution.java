/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private final Stack<Iterator<NestedInteger>> stack;
    private Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return next;
    }

    @Override
    public boolean hasNext() {  
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> nextIterator = stack.peek();
            
            if (!nextIterator.hasNext()) {
                stack.pop();
                continue;
            }
            
            NestedInteger nextNestedInteger = nextIterator.next();
            if (nextNestedInteger.isInteger()) {
                next = nextNestedInteger.getInteger();
                return true;
            } else {
                stack.push(nextNestedInteger.getList().iterator());
            }
        }
        
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */