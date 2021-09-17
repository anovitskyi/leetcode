class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int num : nums1) {
            int counter = map.getOrDefault(num, 0);
            map.put(num, counter + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            int counter = map.getOrDefault(num, 0);
            
            if (counter > 0) {
                result.add(num);
                map.put(num, counter - 1);
            }
        }
        
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            res[i] = result.get(i);
        }
        return res;
    }
}