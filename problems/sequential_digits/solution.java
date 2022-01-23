class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String text = "123456789";
        List<Integer> result = new LinkedList<>();
        
        for (int length = 1; length <= text.length(); ++length) {
            for (int number = 0; number <= text.length() - length; ++number) {
                Integer n = Integer.parseInt(text.substring(number, number + length));
                if (n >= low && n <= high) {
                    result.add(n);
                }
            }
        }
        
        return result;
    }
}