class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int num : nums1) {
            int q = map.getOrDefault(num, 0);
            map.put(num, q + 1);
        }
        
        List<Integer> list = new LinkedList<>();
        for (int num : nums2) {
            int q = map.getOrDefault(num, 0);
            if (q > 0) {
                list.add(num);
                map.put(num, q - 1);
            }
        }
        
        int[] res = new int[list.size()];
        int counter = 0;
        for (int num : list) {
            res[counter++] = num;
        }
        return res;
        
    }
}