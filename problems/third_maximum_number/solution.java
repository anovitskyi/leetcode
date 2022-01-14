class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet<>((a, b) -> Integer.compare(b, a));
        for (int num : nums) {
            set.add(num);
        }
        
        Iterator<Integer> iterator = set.iterator();
        if (set.size() < 3) {
            return iterator.next();
        } else {
            iterator.next();
            iterator.next();
            
            return iterator.next();
        }
    }
}