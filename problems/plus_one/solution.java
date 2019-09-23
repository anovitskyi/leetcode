class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        do {
            int sum = digits[index] + 1;
            if (sum != 10) {
                digits[index] = sum;
                return digits;
            } else {
                digits[index] = 0;
            }
        } while (--index >= 0);

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}