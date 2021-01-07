class Solution {
    public int countArrangement(int n) {
        return countArrangement(n, new HashSet<>(0));
    }
    
    private int countArrangement(int n, Set<Integer> prev) { 
        int index = prev.size() + 1;
        if (index > n) {
            return 1;
        }
        
        int counter = 0;
        for (int i = 1; i <= n; ++i) {
            if (!prev.contains(i) && (i % index == 0 || index % i == 0)) {
                Set<Integer> next = new HashSet<>(prev);
                next.add(i);
                counter += countArrangement(n, next);
            }
        }
        return counter;
    }
}