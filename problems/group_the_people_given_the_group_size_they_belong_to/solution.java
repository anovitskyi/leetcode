class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int person = 0; person < groupSizes.length; ++person) {
            int groupSize = groupSizes[person];

            if (map.get(groupSize) == null) {
                List<Integer> list = new ArrayList<>(groupSize);
                result.add(list);
                map.put(groupSize, list);
            }

            List<Integer> group = map.get(groupSize);
            group.add(person);

            if (group.size() == groupSize) {
                map.put(groupSize, null);
            }
        }

        return result;
    }
}