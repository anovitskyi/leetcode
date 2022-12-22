class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int num : nums1) {
            if (map.containsKey(num)) {
                continue;
            }

            map.computeIfAbsent(num, x -> new ArrayList<>()).add(1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num).get(map.get(num).size() - 1) == 2) {
                continue;
            }

            map.computeIfAbsent(num, x -> new ArrayList<>()).add(2);
        }

        for (int num : nums3) {
            if (map.containsKey(num) && map.get(num).get(map.get(num).size() - 1) == 3) {
                continue;
            }

            map.computeIfAbsent(num, x -> new ArrayList<>()).add(3);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}