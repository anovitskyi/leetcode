class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = List.of(1);

        while (rowIndex-- > 0) {
            List<Integer> copy = new ArrayList<>(result.size() + 1);

            for (int i = 0; i < result.size() + 1; ++i) {
                int prev = 0;
                if (i - 1 >= 0) {
                    prev = result.get(i - 1);
                }

                int curr = 0;
                if (i < result.size()) {
                    curr = result.get(i);
                }
                
                copy.add(prev + curr);
            }

            result = copy;
        }    

        return result;
    }
}