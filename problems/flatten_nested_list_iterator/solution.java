public class NestedIterator implements Iterator<Integer> {

    private final Stack<Iterator<NestedInteger>> stack = new Stack<>();
    private Integer next;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return next;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iterator = stack.peek();
            
            if (!iterator.hasNext()) {
                stack.pop();
                continue;
            }
            
            NestedInteger probablyNext = iterator.next();
            
            if (probablyNext.isInteger()) {
                next = probablyNext.getInteger();
                return true;
            } else if (!probablyNext.getList().isEmpty()) {
                stack.push(probablyNext.getList().iterator());
            }
        }
        
        
        return false;
    }
    
}